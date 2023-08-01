//Java program to send email

import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
//import java.util.Date;
//import javax.swing.*;
//import java.io.IOException;
//import java.security.spec.ECField;
//import java.util.HashMap;
//import javax.mail.MessagingException;import java.util.Random;
//import java.util.concurrent.ExecutionException;

public class SendMail {
    public static void sendMail(String to, String msg) {
        // Recipient's email ID is received as an argument
        // Sender's email ID needs to be mentioned
        // Setting the admins' details by default
        final String from = "mailmariya786@gmail.com";
        final String username = "mailmariya786@gmail.com";
        final String password = "iiwbtowszybbspas";
        
        // Setting up the port to send mail through gmail server
        String host = "smtp.gmail.com";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        // Get the Session object.
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                }
        );

        try {
            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));

            // Set Subject: header field
            message.setSubject("Mail Testing");

            // Now set the actual message
            message.setContent(msg,"text/html");

            // Send message
            Transport.send(message);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}


