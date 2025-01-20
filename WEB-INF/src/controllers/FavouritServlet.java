package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Favourite;
import models.SellerProducts;
import models.User;

@WebServlet("/Favourite.do")

public class FavouritServlet extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException , ServletException{
        
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String nextpage = "succes.jsp";
        Integer userId = user.getUserId();
        Integer sellerProductId = Integer.parseInt(request.getParameter("sellerProductId"));

        ArrayList<Favourite> list = Favourite.collectFavouriteProducts(userId);
        boolean flag = true;

        for (Favourite favourite : list) {

            if (sellerProductId == favourite.getSellerProducts().getSellerProductId()) {
                flag = false;
                break;
            }
        }

        Favourite favourite = new Favourite(new User(userId), new SellerProducts(sellerProductId));

        if (flag) {

            if (favourite.SaveFavouriteProducts()) nextpage = "customer_deshbord.do?start=0";    
            else nextpage = "succes.jsp";
            
        }else{
            if(favourite.DleteFavouriteProducts()) nextpage= "customer_deshbord.do?start=0";
            else  nextpage = "succes.jsp";
        }
        
        request.getRequestDispatcher(nextpage).forward(request, response);
    }

    public void doPost(HttpServletRequest request , HttpServletResponse response)
    throws IOException , ServletException{

        doGet(request, response);
    }
}
