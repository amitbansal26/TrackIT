/**
 * 
 */
package in.sivalabs.trackit.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import in.sivalabs.trackit.domain.Invitation;
import in.sivalabs.trackit.domain.Organization;
import in.sivalabs.trackit.domain.User;
import in.sivalabs.trackit.exceptions.TrackITException;
import in.sivalabs.trackit.mappers.InvitationMapper;
import in.sivalabs.trackit.mappers.OrganizationMapper;
import in.sivalabs.trackit.mappers.UserMapper;

/**
 * @author Siva
 *
 */
@Service
@Transactional
public class UserService 
{
	private PasswordEncoder passwordEncoder;
	private EmailService emailService;
	private UserMapper userMapper;
	private OrganizationMapper organizationMapper;
	private InvitationMapper invitationMapper;
	
	@Autowired
	public UserService(PasswordEncoder passwordEncoder,
					   EmailService emailService, 
					   UserMapper userMapper,
					   OrganizationMapper organizationMapper,
					   InvitationMapper invitationMapper) 
	{
		this.passwordEncoder = passwordEncoder;
		this.emailService = emailService;
		this.userMapper= userMapper;
		this.organizationMapper = organizationMapper;
		this.invitationMapper = invitationMapper;
	}
	
	@Transactional(readOnly=false)
	public User findUserById(Integer id)
	{
		return this.userMapper.selectUserById(id);
	}
	
	public User findUserByEmail(String email)
	{
		return this.userMapper.selectUserByEmail(email);
	}
	
	public void createUser(User user)
	{
		boolean emailExists = this.userMapper.isEmailExists(user.getEmail());
		if(emailExists)
		{
			throw new TrackITException("Email already registered");
		}
		String encPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encPassword );
		String activationToken = UUID.randomUUID().toString();
		user.setActivationToken(activationToken);
		user.setEnabled(false);
		this.userMapper.insertUser(user);
		this.sendActivationEmail(user);
	}

	private void sendActivationEmail(User user)
	{
		emailService.send(user.getEmail(), 
						  "Activate Your TrackIT Account", 
						  "Hello, Please Activate Your TrackIT Account");
	}
	
	public void inviteUser(String fromEmail, String toEmail, Integer organizationId)
	{
		User user = this.userMapper.selectUserByEmail(fromEmail);
		Organization organization = this.organizationMapper.selectOrganizationById(organizationId);
		Invitation invitation = new Invitation();
		invitation.setFromEmail(fromEmail);
		invitation.setOrganization(organization);
		invitation.setToEmail(toEmail);
		String invitationCode = UUID.randomUUID().toString();
		invitation.setInvitationCode(invitationCode);
		invitation.setAccepted(false);
		invitation.setCreatedBy(user.getId());
		invitationMapper.insertInvitation(invitation);
		this.sendInvitationEmail(invitation);
	}
	
	private void sendInvitationEmail(Invitation invitation)
	{
		emailService.send(invitation.getToEmail(), 
						  "Invite To Join TrackIT", 
						  "Hello, Please Register to TrackIT Account");
	}

	public String resetPassword(String email)
	{
		User user = findUserByEmail(email);
		if(user == null)
		{
			throw new RuntimeException("Invalid email address");
		}
		String uuid = UUID.randomUUID().toString();
		user.setForgotPasswordToken(uuid);
		return uuid;
	}

	public void updatePassword(String email, String token, String password)
	{
		User user = findUserByEmail(email);
		if(user == null)
		{
			throw new RuntimeException("Invalid email address");
		}
		if(!StringUtils.hasText(token) || !token.equals(user.getForgotPasswordToken())){
			throw new RuntimeException("Invalid password reset token");
		}
		user.setPassword(password);
		user.setForgotPasswordToken(null);
	}

	public boolean verifyPasswordResetToken(String email, String token)
	{
		User user = findUserByEmail(email);
		if(user == null)
		{
			throw new RuntimeException("Invalid email address");
		}
		if(!StringUtils.hasText(token) || !token.equals(user.getForgotPasswordToken())){
			return false;
		}
		return true;
	}
}
