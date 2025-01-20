package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.SellerProducts;
import models.User;

@WebServlet("/seller_Product_deshbord.do")

public class SellerProductDeshbord extends HttpServlet {
    
    public void doGet(HttpServletRequest request , HttpServletResponse response)
    throws IOException, ServletException {

        doPost(request, response);

    }

    public void doPost(HttpServletRequest request , HttpServletResponse response)
    throws IOException, ServletException {

        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");

        Integer user_id = user.getUserId();

      //  Integer user_id = Integer.parseInt(request.getParameter("user_id"));

        SellerProducts products = new SellerProducts();

        ArrayList<SellerProducts> sellerProducts = products.collectAllSellerProductDetails(user_id);

        request.setAttribute("sellerProducts",sellerProducts);
        request.setAttribute("size",sellerProducts.size());

        request.getRequestDispatcher("seller_product_deshbord.jsp").forward(request, response);
    }
}
