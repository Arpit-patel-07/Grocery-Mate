package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Dinomination;
import models.Product;
import models.SellerProducts;

import com.google.gson.Gson;

@WebServlet("/fetch_product_information.do")

public class FetchProductInformation extends HttpServlet {
    
    public void doGet(HttpServletRequest request , HttpServletResponse response)
    throws IOException, ServletException{

        Integer product_id = Integer.parseInt(request.getParameter("product_id"));

        SellerProducts list = SellerProducts.collectProductInformation(product_id);
        
        Gson gson = new Gson();

        String resp = gson.toJson(list);

        response.getWriter().write(resp);

    }
}
