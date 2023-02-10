package group22.utils;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import io.github.cdimascio.dotenv.Dotenv;


/**
 * class that sends a notification about the build result to the email specified
*/
 public class SendEmailNotification {
    /**
     * Sends email notification of build result
     * @param subject the subject of the email.
     * @param buildResult the result of the build.
     * @return String if the email was successfully sent
     */
    public static String sendEmailNotification( String subject, String buildResult) {     
        Dotenv dotenv = Dotenv.configure().directory("./src/main/java/group22/resources").load();
        final String to =dotenv.get("RECIPIENT_EMAIL");
        final String username = dotenv.get("GMAIL_USER");
        final String password = dotenv.get("GMAIL_PASSWORD");
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
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText("Build result: "+ buildResult);
            Transport.send(message);

            String res="Email sent successfully";
            return res;
        } catch (MessagingException e) {
            return e.getMessage();
        }
    }
}
