package utils;

import javax.mail.PasswordAuthentication;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class EmailSender {

    public  static boolean SendEmail(String form, String to, String subject, String emailContent){

         boolean flag = false;

        Properties prop = new Properties();

        prop.put("mail.transport.protocol","smtp");
        prop.put("mail.smtp.host","smtp-mail.outlook.com");                                      
        prop.put("mail.smtp.port","587");
        prop.put("mail.smtp.auth","true");
        prop.put("mail.smtp.starttls.enable","true");

        Session mailSession = Session.getInstance(prop, new EmailAuthenticator());

        MimeMessage message = new MimeMessage(mailSession);

        try {
            message.setFrom(form);
            message.setRecipients(RecipientType.TO, to);
            message.setSubject(subject);
            message.setContent(emailContent,"text/html");

            Transport.send(message);

            flag = true;

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return flag;
    }

    private static class EmailAuthenticator extends Authenticator {

        public javax.mail.PasswordAuthentication  getPasswordAuthentication() {

            return new PasswordAuthentication("arpitpatel2607x@outlook.com", "Kakshihatake07");
        }
    }
}

