package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/product_pic.do")

public class ProductPicServlet extends HttpServlet{
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException{

        Integer product_id = Integer.parseInt(request.getParameter("product_id"));

        String nextpage = "product_pic.jsp?product_id"+product_id;
        
        request.getRequestDispatcher(nextpage).forward(request, response);
    }
}
