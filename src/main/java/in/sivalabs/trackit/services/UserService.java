/**
 * 
 */
package in.sivalabs.trackit.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	private EmailService emailService;
	private UserMapper userMapper;
	private OrganizationMapper organizationMapper;
	private InvitationMapper invitationMapper;
	
	@Autowired
	public UserService(EmailService emailService, 
					   UserMapper userMapper,
					   OrganizationMapper organizationMapper,
					   InvitationMapper invitationMapper) 
	{
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
}
