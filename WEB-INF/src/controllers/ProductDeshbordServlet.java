package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import models.Product;


@WebServlet("/products.do")

public class ProductDeshbordServlet extends HttpServlet {

     public void doGet(HttpServletRequest request , HttpServletResponse response)
    throws IOException , ServletException{

       doPost(request, response);
        
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException , ServletException{

        Integer category_id = Integer.parseInt(request.getParameter("category_id"));

        ArrayList<Product> products = Product.CollectAllProducts(category_id);

        HttpSession session = request.getSession();

        session.setAttribute("products", products);

        request.getRequestDispatcher("product_deshbord.jsp?category_id"+category_id).forward(request, response);
       
    }
}
