package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Status;
import models.User;
import models.UserType;
import utils.MessageTempletes;

@WebServlet("/login.do")

public class LoginServlet extends HttpServlet {

    String nextpage = "login.jsp";

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        request.getRequestDispatcher("login.jsp").forward(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Integer userTypeId = Integer.parseInt(request.getParameter("user_Type_Id"));

        HttpSession session = request.getSession();
    
        if (userTypeId == 1) {

            User user = new User(email, password, new UserType(userTypeId));
        
            int result = user.login();


            if (result == 0) {
    
                // Handeli ng Exception

            } else if (result == 3) {

                int statusId = user.getStatus().getStatusId();

                if (statusId == Status.ACTIVE) {

                    session.setAttribute("user", user);

                    // Do some code after Exams

                } else if (statusId == Status.BLOCKED) {

                    // Do some code after Exams

                } else if (statusId == Status.CLOSED) {

                    //  // Do some code after Exams

                } else if (statusId == Status.EMAIL_VERIFIED) {

                    nextpage = "message.jsp?message="+ MessageTempletes.getIncompleteManualVerificationMessage();
                    
                } else if (statusId == Status.INACTIVE) {

                     // Do some code after Exams

                } else if (statusId == Status.MANUAL_VERIFICATION) {

                    session.setAttribute("user", user);

                    nextpage = "category_deshbord.jsp?userTypeId="+userTypeId;
                }

            } else if (result == 2) {

                nextpage = "login.jsp?user_type_id="+userTypeId+"&pass_incorrect_message="+MessageTempletes.getIncorrectPasswordMessage();

            } else if (result == 1) {

                nextpage = "login.jsp?user_type_id="+userTypeId+"&email_incorrect_message="+MessageTempletes.getIncorrectEmailMessage();
            }
        }
        
        else if(userTypeId == 2) {

            User user = new User(email, password, new UserType(userTypeId));
        
            int result = user.login();

            if (result == 0) {
    
                // Handeli ng Exception

            } else if (result == 3) {

                int statusId = user.getStatus().getStatusId();

                if (statusId == Status.ACTIVE) {

                    session.setAttribute("user", user);

                    // Do some code after Exams

                } else if (statusId == Status.BLOCKED) {

                    // Do some code after Exams

                } else if (statusId == Status.CLOSED) {

                    //  // Do some code after Exams

                } else if (statusId == Status.EMAIL_VERIFIED) {

                    nextpage = "message.jsp?message="+ MessageTempletes.getIncompleteManualVerificationMessage();
                    
                } else if (statusId == Status.INACTIVE) {

                     // Do some code after Exams

                } else if (statusId == Status.MANUAL_VERIFICATION) {

                    session.setAttribute("user", user);

                  //  nextpage = "category_deshbord.jsp?userTypeId="+userTypeId;
                      nextpage = "seller_Product_deshbord.do";
                }

            } else if (result == 2) {

                nextpage = "login.jsp?user_type_id="+userTypeId+"&pass_incorrect_message="+MessageTempletes.getIncorrectPasswordMessage();

            } else if (result == 1) {

                nextpage = "login.jsp?user_type_id="+userTypeId+"&email_incorrect_message="+MessageTempletes.getIncorrectEmailMessage();
            }
        }
        
        else if(userTypeId == 3) {

            User user = new User(email, password, new UserType(userTypeId));
        
            int result = user.login();

            if (result == 0) {
    
                // Handeli ng Exception

            } else if (result == 3) {

                session.setAttribute("user", user);

                nextpage = "customer_deshbord.do?start="+0;

            } else if (result == 2) {

                nextpage = "login.jsp?user_type_id="+userTypeId+"&pass_incorrect_message="+MessageTempletes.getIncorrectPasswordMessage();

            } else if (result == 1) {

                nextpage = "login.jsp?user_type_id="+userTypeId+"&email_incorrect_message="+MessageTempletes.getIncorrectEmailMessage();
            }
        }

        request.getRequestDispatcher(nextpage).forward(request, response);
    }
}
