package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Dinomination;
import models.Product;
import models.WeightType;
@WebServlet("/save_dinomination.do")

public class SaveDinominationDetailsServlet extends HttpServlet{

    public void doGet(HttpServletRequest request , HttpServletResponse response)
    throws IOException, ServletException{

        Integer productId =Integer.parseInt(request.getParameter("product_id"));

        String nexpage = "addDinomination_Details.jsp?product_id="+productId;

        request.getRequestDispatcher(nexpage).forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException{

        String nextpage = "login.jsp";
        
        Integer productId = Integer.parseInt(request.getParameter("product_id"));
        Integer weightTypeId = Integer.parseInt(request.getParameter("weightTypeId"));
        Integer prise = Integer.parseInt(request.getParameter("prise"));
        Integer weight = Integer.parseInt(request.getParameter("weight"));
    
        Dinomination dinomination = new Dinomination(new Product(productId), prise, weight, new WeightType(weightTypeId));

        if (dinomination.SaveDinominationDetails()) {
         
             nextpage = "product_deshbord.jsp";
        }
        
        request.getRequestDispatcher(nextpage).forward(request, response);
    }
}