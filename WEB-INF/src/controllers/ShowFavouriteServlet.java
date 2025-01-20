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
import models.User;

@WebServlet("/show_favourite.do")

public class ShowFavouriteServlet extends HttpServlet {
    
    public void doGet(HttpServletRequest request , HttpServletResponse response)
    throws IOException , ServletException{

        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");

        if (user != null) {

            Integer userId = user.getUserId();
            ArrayList<Favourite> list = Favourite.collectFavouriteProducts(userId);

            request.setAttribute("list",list);
            request.setAttribute("size", list.size());
        }

        request.getRequestDispatcher("succes.jsp").forward(request, response);
    }
}
