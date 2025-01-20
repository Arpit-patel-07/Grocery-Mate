package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Dinomination;
import models.SellerProducts;
import models.User; 
       
@WebServlet("/seller_product_details.do")

public class SellerDetailsServlet extends HttpServlet {
    
    public void doGet(HttpServletRequest request , HttpServletResponse response)
    throws IOException , ServletException{

        doPost(request, response);
    }

    public void doPost(HttpServletRequest request , HttpServletResponse response)
    throws IOException , ServletException{

        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");

        Integer dinominationId =Integer.parseInt(request.getParameter("dinominationId"));
        Integer quantity =Integer.parseInt(request.getParameter("quantity"));
        Integer discount = Integer.parseInt(request.getParameter("discount"));
        Integer sold = Integer.parseInt(request.getParameter("sold"));
        java.sql.Date record_date = java.sql.Date.valueOf(request.getParameter("record_date"));
        Integer user_id = user.getUserId();


        SellerProducts sellerProducts = new SellerProducts(new User(user.getUserId()), new Dinomination(dinominationId), quantity, discount, sold , record_date);

        sellerProducts.SaveSellerProductDetails();

        request.getRequestDispatcher("seller_Product_deshbord.do?user_id="+user_id).forward(request, response);
    }
}
