package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.SellerProducts;

@WebServlet("/customer_deshbord.do")

public class CustomerDeshbordServlet extends HttpServlet {
    
    public void doGet(HttpServletRequest request , HttpServletResponse response)
    throws IOException , ServletException{

        Integer start = Integer.parseInt(request.getParameter("start"));
        SellerProducts products = new SellerProducts();
                                
        ArrayList<SellerProducts> sellerProducts = products.collectAllSellerProduct(start);

        request.setAttribute("sellerProducts",sellerProducts);
        request.setAttribute("size",sellerProducts.size());

        request.getRequestDispatcher("customer_deshbord.jsp?value="+1+"&start="+start).forward(request, response);

    }

    public void doPost(HttpServletRequest request , HttpServletResponse response)
    throws IOException , ServletException{

        doGet(request, response);
    }
}
