package controllers;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import models.PicType;
import models.Product;
import models.ProductPics;
import models.User;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;


@WebServlet("/product_pic_upload.do")

public class ProductUploadPicServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        boolean flag = ServletFileUpload.isMultipartContent(request);

        ServletContext context = getServletContext();

        String path = context.getRealPath("/WEB-INF/uploads/manufacture/product/");

        Integer product_id = null;
        Integer pic_Type_id = null;
        String fileName  = null;

        if (flag) {

            try {
                List<FileItem> fileItems = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);

                for (FileItem fileItem : fileItems) {

                    if (fileItem.isFormField()) {

                        String fieldname = fileItem.getFieldName();
                        String fieldvalue = fileItem.getString();

                        switch (fieldname) {

                            case "product_id":
                            product_id = Integer.parseInt(fieldvalue);
                            break;

                            case "picTypeId":
                            pic_Type_id = Integer.parseInt(fieldvalue);
                            break;
                        }

                    } else {

                         fileName = product_id+"."+fileItem.getName().split("\\.")[1];
        

                        File file = new File(path, fileName);

                        try {
                            fileItem.write(file);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            }

            ProductPics pics = new ProductPics(new Product(product_id), fileName, new PicType(pic_Type_id));

            pics.SaveProductPics();

        }

        request.getRequestDispatcher("product_deshbord.jsp").forward(request, response);
    }

     public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        
        User user = (User)session.getAttribute("user");

        ServletContext context = getServletContext();

        if(user!=null) {

            Integer productId = Integer.parseInt(request.getParameter("product_id"));

            String productPicPath = ProductPics.getProductPicPath(productId);

            InputStream is = context.getResourceAsStream("/WEB-INF/uploads/manufacture/product/"+productPicPath);

            OutputStream os = response.getOutputStream();

            byte[] arr = new byte[256];
            while(is.read(arr) != -1) {
                os.write(arr);
            }
            os.close();
        }
    } 
}