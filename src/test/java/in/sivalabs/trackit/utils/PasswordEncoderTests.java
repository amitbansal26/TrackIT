/**
 * 
 */
package in.sivalabs.trackit.utils;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Siva
 *
 */
public class PasswordEncoderTests
{
	PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@Test
	public void generatePasswords()
	{
		System.out.println("PlainText:"+"superadmin"+", encrypted:"+passwordEncoder.encode("superadmin"));
		System.out.println("PlainText:"+"admin"+", encrypted:"+passwordEncoder.encode("admin"));
		System.out.println("PlainText:"+"siva"+", encrypted:"+passwordEncoder.encode("siva"));
		System.out.println("PlainText:"+"prasad"+", encrypted:"+passwordEncoder.encode("prasad"));
		System.out.println("PlainText:"+"neha"+", encrypted:"+passwordEncoder.encode("neha"));
		System.out.println("PlainText:"+"ramu"+", encrypted:"+passwordEncoder.encode("ramu"));
		System.out.println("PlainText:"+"suman"+", encrypted:"+passwordEncoder.encode("suman"));
		

	}
}
