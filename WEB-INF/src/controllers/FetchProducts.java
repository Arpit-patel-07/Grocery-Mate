package controllers;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.SellerProducts;

@WebServlet("/fetch_product.do")

public class FetchProducts  extends HttpServlet{
    
    public void doPost(HttpServletRequest request , HttpServletResponse response)
    throws IOException,ServletException{

        String nextpage = "succes.jsp";
        
        Integer category_id =Integer.parseInt(request.getParameter("category_id"));

        ArrayList<SellerProducts> products = SellerProducts.CollectAllProducts(category_id);

        request.setAttribute("products", products);
        System.out.println(products);
        request.setAttribute("size", products.size());

        nextpage = "customer_deshbord.jsp?value="+2;

        request.getRequestDispatcher(nextpage).forward(request , response);
    }
    

    public void doGet(HttpServletRequest request , HttpServletResponse response)
    throws IOException,ServletException{

        // String nextpage = "productDetails_deshbord.jsp";

        // Integer product_id = Integer.parseInt(request.getParameter("product_id"));

        // SellerProducts sellerProducts = SellerProducts.collectAllProductDetails(product_id);

        // request.setAttribute("sellerProducts",sellerProducts);

        // request.getRequestDispatcher(nextpage).forward(request,response);

    }
}
