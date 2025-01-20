package controllers;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Cart;
import models.CartItem;
import models.Dinomination;
import models.Product;
import models.SellerProducts;
import models.Status;
import models.User;

@WebServlet("/addTo_Cart.do")

public class AddToCartServlet extends HttpServlet {
    
    public  void doGet(HttpServletRequest request , HttpServletResponse response)
    throws IOException , ServletException{

         HttpSession session = request.getSession();

        User user = (User)session.getAttribute("user");
        Cart cart = (Cart)session.getAttribute("cart");

        /*if () {

            status is panding then get the pending cart....

        }else{

            // write code here ....................
        }
        */
       
       
        Integer discount = Integer.parseInt(request.getParameter("discount"));
        Integer sellerProductId = Integer.parseInt(request.getParameter("seller_product_id"));
        Integer prise = Integer.parseInt(request.getParameter("price"));
        Integer product_id = Integer.parseInt(request.getParameter("product_id"));
        String name = request.getParameter("name");
        Integer quantity = Integer.parseInt(request.getParameter("quantity"));
       // Integer dinomination_id = Integer.parseInt(request.getParameter("dinomination_id"));
        
        if (user != null) {

            if (cart == null) {

                cart = new Cart();
                Date cartDate = Date.valueOf(LocalDate.now());

                cart.setCartDate(cartDate);
                cart.setUser(user);
                cart.setStatus(new Status(Status.PENDING));
                cart.setItemCount(1);
                cart.setTotalAmount(prise);

                cart.creteCart();

                session.setAttribute("cart",cart);
                ArrayList<CartItem> cart_item = new ArrayList<CartItem>();
                session.setAttribute("cart_items", cart_item);
            }
            else{
                cart.setItemCount(cart.getItemCount()+1);
                cart.setTotalAmount(cart.getTotalAmount()+prise);
            }

            @SuppressWarnings("unchecked")
            ArrayList<CartItem> list = (ArrayList<CartItem>) session.getAttribute("cart_items");
            System.out.println(quantity);
            list.add(new CartItem(cart, new SellerProducts(sellerProductId,quantity,discount,new Dinomination(prise,new Product(product_id, name)))));
            response.sendRedirect("customer_deshbord.do?start="+0);
            
        }else{

           // if user == null  
        }
    }

    public void doPost(HttpServletRequest request , HttpServletResponse response)
    throws IOException , ServletException{
        doGet(request, response);
    }
}
