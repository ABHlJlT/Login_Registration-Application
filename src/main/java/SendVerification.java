


import java.util.Properties;
import javax.mail.Session;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.MimeMessage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abhijit
 */
public class SendVerification 
{
        public static String SendMail(String email)
        {
            String st=null;
            
            
            
        Properties props = new Properties();

        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");	
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        
        Session session = Session.getDefaultInstance(props,new Authenticator() 
        {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() 
            {
                return new PasswordAuthentication("norply.verify@gmail.com", "9932055252");
            }
        });

        try 
        {
            String msg="click the link to verify--- http://localhost:8084/RegisterLogin/linkverification.jsp?email="+email;
            Message message = new MimeMessage(session);
            
            message.setFrom(new InternetAddress("norply.verify@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("--VERYFY YOUR REGSITRATION--");
         //   message.setText("click the link to verify--- http://localhost:8084/RegisterLogin/linkverification.jsp");
            message.setText(msg);

            Transport.send(message);
            st="Verification Link Sent!";
           
        } catch (MessagingException e) 
        {
           
            st="Verification Link Sending Error!";
            throw new RuntimeException(e);
        }
        return st;
    }
    
    
       
}
    
    
    
    
    
    
    
    
    
    
    
    
    