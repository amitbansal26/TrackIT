/**
 * 
 */
package in.sivalabs.trackit.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.sivalabs.trackit.domain.User;
import in.sivalabs.trackit.exceptions.TrackITException;
import in.sivalabs.trackit.mappers.UserMapper;

/**
 * @author Siva
 *
 */
@Service
@Transactional(readOnly=true)
public class UserService 
{
	private UserMapper userMapper;
	private EmailService emailService;
	
	@Autowired
	public UserService(EmailService emailService, 
					   UserMapper userMapper) 
	{
		this.emailService = emailService;
		this.userMapper= userMapper;
	}
	
	public User findUserById(Integer id)
	{
		return this.userMapper.selectUserById(id);
	}
	
	@Transactional(readOnly=false)
	public void createUser(User user)
	{
		boolean emailExists = this.userMapper.isEmailExists(user.getEmail());
		if(emailExists)
		{
			throw new TrackITException("Email already registered");
		}
		String activationToken = UUID.randomUUID().toString();
		user.setActivationToken(activationToken);
		user.setEnabled(false);
		this.userMapper.insertUser(user);
		this.sendActivationEmail(user);
	}

	private void sendActivationEmail(User user)
	{
		emailService.send(user.getEmail(), "Activate Your TrackIT Account", "Hello, Please Activate Your TrackIT Account");
	}
}
