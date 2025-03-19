import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailTest {
    public static void main(String[] args) {
        final String EMAIL_FROM = "surajjavacv@gmail.com";
        final String EMAIL_PASSWORD = "rtde chuq fjnf zuqv";
        final String EMAIL_TO = "ss2484906@gmail.com"; // Change this to your email

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EMAIL_FROM, EMAIL_PASSWORD);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(EMAIL_FROM));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(EMAIL_TO));
            message.setSubject("Test Email from Java");
            message.setText("This is a test email from Java.");

            Transport.send(message);
            System.out.println("✅ Email sent successfully!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
