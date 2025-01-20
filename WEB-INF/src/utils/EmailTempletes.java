package utils;

public class EmailTempletes {
    
    public static String generateWelcomeMail(String name, String email,String verificationCode ,Integer userTypeId ){

        String welcomeMail = "<h1>Welcome "+ name+"</h1><hr><p style='font-weight:bold;font-size:22px;color:red'>" +
        "Please click over the account activation link or active your account juts in a miniute <a href='http://localhost:9090/gsms_project/email_verify.do?email="+email+
        "&verification_code="+verificationCode+"&user_type_id="+userTypeId+"'>" + 
        "Activation Link</a></p>";
        
        return welcomeMail;
    }
}

