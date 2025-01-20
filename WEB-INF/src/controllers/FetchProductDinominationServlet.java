package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

import models.Dinomination;
import models.Product;

@WebServlet("/fetch_dinomination.do")

public class FetchProductDinominationServlet extends HttpServlet {

    public void doGet(HttpServletRequest request , HttpServletResponse response)
    throws IOException , ServletException{

        Integer product_id = Integer.parseInt(request.getParameter("product_id"));

        Dinomination dinomination = new Dinomination(new Product(product_id));

        ArrayList<Dinomination> list =  dinomination.CollectAllDinominationDetails();
        
        Gson gson = new Gson();

        String resp = gson.toJson(list);

        response.getWriter().write(resp);
    }
}
