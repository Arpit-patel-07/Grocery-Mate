package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import utils.MessageTempletes;

@WebServlet("/email_verify.do")

public class VerfiyEmailServlet extends HttpServlet{
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException{

        String email = request.getParameter("email");
        String verificationCode = request.getParameter("verification_code");
        Integer userTypeId = Integer.parseInt(request.getParameter("user_type_id"));

        boolean flag =  User.verifyEmail(email, verificationCode, userTypeId);

        String nextpage = "login.jsp?user_Type_Id="+userTypeId;

        if (userTypeId == 3) {

            nextpage ="login.jsp?user_Type_Id="+userTypeId;
            
        }
        else if(flag) {

            nextpage = "message.jsp?color=alert-warning&message="+MessageTempletes.getEmailVerificationSuccesMessage();
        }
        
        request.getRequestDispatcher(nextpage).forward(request, response);
    }
}
