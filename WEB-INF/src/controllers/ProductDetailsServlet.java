package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import models.Product;
import models.Category;

@WebServlet("/product_details.do")

public class ProductDetailsServlet extends HttpServlet {

     public void doGet(HttpServletRequest request , HttpServletResponse response)
    throws IOException , ServletException{

       doPost(request, response);
        
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException , ServletException{

        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String nextpage = "notsucces.jsp";

        System.out.println("category id is : "+request.getParameter("category_id"));
        Integer category_id = Integer.parseInt(request.getParameter("category_id"));
        Integer shelf_Life = Integer.parseInt(request.getParameter("shelf_Life"));
        String name= request.getParameter("product_Name");
        String brand = request.getParameter("brand");
        String packaging = request.getParameter("packaging");
        String storage_Info = request.getParameter("storage_Info");

        Product product = new Product(name, shelf_Life, user, brand, storage_Info, packaging, new Category(category_id));

       boolean b =  product.saveProductDetails();

       if (b)     
       nextpage = "products.do";

    request.getRequestDispatcher(nextpage).forward(request, response);
    
    }
}
