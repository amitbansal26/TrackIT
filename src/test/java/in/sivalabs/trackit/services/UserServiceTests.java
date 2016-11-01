/**
 * 
 */
package in.sivalabs.trackit.services;

import static org.junit.Assert.*;

import javax.mail.internet.MimeMessage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.subethamail.wiser.Wiser;
import org.subethamail.wiser.WiserMessage;

import in.sivalabs.trackit.TrackITApplication;
import in.sivalabs.trackit.config.TrackITSettings;
import in.sivalabs.trackit.domain.User;

/**
 * @author Siva
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes=TrackITApplication.class, webEnvironment=WebEnvironment.NONE)
public class UserServiceTests 
{
	@Autowired TrackITSettings trackitSettings;
	
	@Autowired UserService userService;
	@Value("${spring.mail.port:26}") int smtpPort;
	
	private Wiser wiser;

    @Before
    public void setup() {
        wiser = new Wiser();
        wiser.setPort(smtpPort);
        wiser.start();

        //MailTestUtils.reconfigureMailSenders(applicationContext, 2500);
    }
    
    @After
    public void after() {
        wiser.stop();
    }
    
	@Test
	public void findUserById()
	{
		User user = userService.findUserById(999);
		assertNull(user);
		
		user = userService.findUserById(1);
		assertNotNull(user);
		assertEquals("superadmin", user.getName());
		assertEquals("superadmin@gmail.com", user.getEmail());
		assertEquals("superadmin", user.getPassword());
	}
	
	@Test
	public void createUser() throws Exception
	{
		User user = new User();
		user.setEmail("siva@gmail.com");
		user.setPassword("siva");
		user.setName("Siva");
		userService.createUser(user);
		assertNotNull(user.getId());
		
		assertEquals("No mail messages found", 1, wiser.getMessages().size());

        if (wiser.getMessages().size() > 0) 
        {
            WiserMessage wMsg = wiser.getMessages().get(0);
            MimeMessage msg = wMsg.getMimeMessage();

            assertNotNull("message was null", msg);
            assertEquals("'Subject' did not match", "Activate Your TrackIT Account", msg.getSubject());
            assertEquals("'From' address did not match", trackitSettings.getSupportEmail(), msg.getFrom()[0].toString());
            assertEquals("'To' address did not match", "siva@gmail.com", msg.getRecipients(MimeMessage.RecipientType.TO)[0].toString());
        }
	}
}
