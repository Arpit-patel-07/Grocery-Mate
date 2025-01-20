package controllers;

import java.io.File;
import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;
import models.UserType;
import utils.AppUtil;
import utils.EmailSender;
import utils.EmailTempletes;
import utils.MessageTempletes;
import models.City;

@WebServlet("/signup.do")

public class SignupServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        request.getRequestDispatcher("signup.jsp").forward(request, response);
    }

        public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        ServletContext context = getServletContext();
        boolean value = false;
        String nexpage = "notsucces.jsp";


        String name = request.getParameter("name");

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Integer cityId = Integer.parseInt(request.getParameter("city_id"));
        String contact = request.getParameter("contact");
        Integer userTypeId = Integer.parseInt(request.getParameter("user_type_id"));
        String verficationCode = AppUtil.generateEmailVerificationCode();
        String address = request.getParameter("address");

        
        if (userTypeId == 1 || userTypeId == 2) {
            Date registrationDate = Date.valueOf(request.getParameter("registration_date"));
            User user = new User(name, email, password, new City(cityId), contact, new UserType(userTypeId),verficationCode,address,registrationDate);
            value = user.saveUsersRecords();
        }
        if (userTypeId == 3) 
        {
            Date dateOfBirth = Date.valueOf(request.getParameter("DateOfBirth")); 
            String gender =  request.getParameter("gender");
            User user = new User(name, email, password, new City(cityId), contact, new UserType(userTypeId),verficationCode,address,gender,dateOfBirth);
            value =  user.saveCustomerRecords();
        }
        
        if (value) {
            
            String subject = "Welcome users...";

            String from = context.getInitParameter("from_email");
            
           // String fromPassw = context.getInitParameter("from_email_password");

            String content = EmailTempletes.generateWelcomeMail(name, email, verficationCode, userTypeId);
            
            EmailSender.SendEmail(from, email, subject, content);
            
            String userPath = context.getRealPath("WEB-INF/uploads/"+UserType.types[userTypeId-1].toLowerCase()); 
            File file = new File(userPath, email);
            file.mkdir();
            nexpage = "message.jsp?message="+MessageTempletes.getSignupSuccesMessage();
            
        }
        
        response.sendRedirect(nexpage);

    }
}
