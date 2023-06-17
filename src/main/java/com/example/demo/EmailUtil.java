package com.example.demo;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailUtil {
    // Method to send an email
    public static void sendEmail(String toEmail, String subject, String message) {
        // Set up properties for the email server
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Create a session with the properties
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("tdas363@gmail.com", "pnevnmfhglpwzcmi");
            }
        });

        try {
            // Create a MimeMessage object
            MimeMessage mimeMessage = new MimeMessage(session);

            // Set the recipient(s)
            mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));

            // Set the subject
            mimeMessage.setSubject(subject);

            // Set the message content
            mimeMessage.setText(message);

            // Send the email
            Transport.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
            // Handle any exceptions that occurred during sending
        }
    }
}