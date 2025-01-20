package controllers;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.CartItem;
import models.User;
@WebServlet("/delete_cartitem.do")

public class DeleteCartsitemServlet  extends HttpServlet {
    
    public void doGet(HttpServletRequest request , HttpServletResponse response)
    throws IOException , ServletException{

        doPost(request, response);
    }

    public void doPost(HttpServletRequest request , HttpServletResponse response)
    throws IOException , ServletException{

        Integer seller_product_id = Integer.parseInt(request.getParameter("seller_product_id"));
        HttpSession session = request.getSession();

        User user = (User)session.getAttribute("user");

        if (user != null) {
            
            @SuppressWarnings("unchecked")

            ArrayList<CartItem> cartItems =(ArrayList<CartItem>)session.getAttribute("cart_items");
            int index = 0;

            for (CartItem items : cartItems) {

                if (items.getSellerProduct().getSellerProductId() == seller_product_id){
                    cartItems.remove(index);
                    break;
                    //cartItems.remove(items);
                }
                index = index + 1;
            }
        }
        else{

            // Handel session if user is null...
        }

        response.sendRedirect("customer_deshbord.do?start="+0);
    }
}
