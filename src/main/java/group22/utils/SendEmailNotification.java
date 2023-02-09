package group22.utils;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

//class that sends a notification about the build result to the email specified
public class SendEmailNotification {
    /**
     * Sends email notification of build result
     * @param recipientEmail the email to the recipient.
     * @param subject the subject of the email.
     * @param buildResult the result of the build.
     */
    public static void sendEmailNotification(String recipientEmail, String subject, String buildResult) {     
        // Recipient's email ID 
        String to = recipientEmail;
        // Sender's email ID 
        String from = "dd2480group22@gmail.com";
        final String username = "dd2480group22@gmail.com";
        final String password = EnvironmentVars.getPassword();

    
        // Assuming you are sending email through Gmail SMTP
        String host = "smtp.gmail.com";
    
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

	
        Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText("Build result: "+ buildResult);
            Transport.send(message);

            System.out.println("Email sent successfully");
        } catch (MessagingException e) {
            System.out.println(e.getMessage());
        }
    }
}
