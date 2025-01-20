package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Cart;
import models.CartItem;

import models.User;

@WebServlet("/order.do")

public class PlaceOrderServlet extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException , ServletException{

        HttpSession session = request.getSession();

        User user = (User)session.getAttribute("user");

        if (user != null) {
            
            @SuppressWarnings("unchecked")

            ArrayList<CartItem> cartItems =(ArrayList<CartItem>)session.getAttribute("cart_items");

            for (CartItem items : cartItems) {

                items.addcartItems();
                
            }

            Cart cart = (Cart)session.getAttribute("cart");
            Cart obj = new Cart(cart.getTotalAmount(), cart.getItemCount(), cart.getStatus(),cart.getCartId());
            obj.updateCart();

            session.removeAttribute("cart_items");
            session.removeAttribute("cart");
        }

        request.getRequestDispatcher("customer_deshbord.do?start="+0).forward(request, response);
    }
}
