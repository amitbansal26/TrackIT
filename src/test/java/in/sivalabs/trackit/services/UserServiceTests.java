/**
 * 
 */
package in.sivalabs.trackit.services;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import in.sivalabs.trackit.TrackITApplication;
import in.sivalabs.trackit.domain.User;

/**
 * @author Siva
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes=TrackITApplication.class, webEnvironment=WebEnvironment.NONE)
public class UserServiceTests 
{
	@Autowired UserService userService;
	
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
}
