package utils;

public class MessageTempletes {
    
    public static String getSignupSuccesMessage(){

        String signupSuccesMessage = "Your Account is created!! A verification mail is sent."+
        " Please verify your email...";

        return signupSuccesMessage;
    }

    public static String getEmailVerificationSuccesMessage(){

        String  EmailVerificationSuccesMessage = "Your Email Verification is Done...."+
        "!! We will initiate a Mannual Verification. Ones Your Manual Verification is done"+
        " You will be able to login..!";

        return EmailVerificationSuccesMessage;
    }

    public static String getIncorrectEmailMessage(){

        String IncorrectEmailMessage = "Account with the given email does not exist or your email is incorrect.. please check";

        return IncorrectEmailMessage;
    }

    public static String getIncorrectPasswordMessage(){

        String IncorrectPasswordMessage = "Invalid Password... Please Try Again...!!";

        return IncorrectPasswordMessage;
    }

    public static String getIncompleteManualVerificationMessage(){

        String IncompleteManualVerificationMessage  = "You manual verfication is under Process...please Try after some time !! ";

        return IncompleteManualVerificationMessage;
    }
}
