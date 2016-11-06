/**
 * 
 */
package in.sivalabs.trackit.services;

import static org.junit.Assert.*;

//import javax.mail.internet.MimeMessage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
//import org.subethamail.wiser.Wiser;
//import org.subethamail.wiser.WiserMessage;

import in.sivalabs.trackit.TrackITApplication;
import in.sivalabs.trackit.config.TrackITSettings;
import in.sivalabs.trackit.domain.User;
import in.sivalabs.trackit.model.UserProfile;

/**
 * @author Siva
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes=TrackITApplication.class, webEnvironment=WebEnvironment.NONE)
public class UserServiceTests 
{
	@Autowired PasswordEncoder passwordEncoder;
	@Autowired TrackITSettings trackitSettings;
	
	@Autowired UserService userService;
	@Value("${spring.mail.port:26}") int smtpPort;
	
	//private Wiser wiser;

    @Before
    public void setup() {
    	/*
        wiser = new Wiser();
        wiser.setPort(smtpPort);
        wiser.start();
    	 */
    }
    
    @After
    public void after() {
        //wiser.stop();
    }
    
	@Test
	public void findUserById()
	{
		User user = userService.findUserById(999);
		assertNull(user);
		
		user = userService.findUserById(1);
		assertNotNull(user);
		assertEquals("SuperAdmin", user.getName());
		assertEquals("superadmin@gmail.com", user.getEmail());
		assertTrue(passwordEncoder.matches("superadmin", user.getPassword()));
	}
	
	@Test
	public void createUser() throws Exception
	{
		User user = new User();
		user.setEmail("testuser@gmail.com");
		user.setPassword("testuser");
		user.setName("TestUser");
		userService.createUser(user);
		assertNotNull(user.getId());
		/*
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
        */
	}
	
	@Test
	public void inviteUser() throws Exception
	{
		Integer organizationId = 1;
		String fromEmail = "superadmin@gmail.com";
		String toEmail = "siva@gmail.com";
		userService.inviteUser(fromEmail, toEmail, organizationId);
	}
	
	@Test
	public void getUserProfile() throws Exception
	{
		String email = "siva@gmail.com";
		UserProfile userProfile = userService.getUserProfile(email);
		assertNotNull(userProfile);
		System.err.println(userProfile);
	}
}
