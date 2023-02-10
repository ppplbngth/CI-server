package servertests;

import group22.utils.*;
import org.junit.jupiter.api.Test; 
import java.io.IOException;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SendEmailNotificationTest {
    
    /**
     *  Assert that the email is sent successfully
     */
    @Test
    public void testPositiveSendEmailNotification() throws IOException {

        String res=SendEmailNotification.sendEmailNotification("test", "test of email function");
        assertEquals("Email sent successfully",res);
    }

}

