/**
 * 
 */
package in.sivalabs.trackit.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import in.sivalabs.trackit.config.TrackITSettings;

/**
 * @author Siva
 *
 */
@Component
public class EmailService
{
	private Logger logger = LoggerFactory.getLogger(EmailService.class);
	
	@Autowired
	private TrackITSettings trackitSettings;
	

	@Autowired 
	private JavaMailSender javaMailSender;
	
    
	public void send(String toEmail, String subject, String content)
	{
		String supportEmail = trackitSettings.getSupportEmail();
		
		SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(toEmail);
        mailMessage.setReplyTo(supportEmail);
        mailMessage.setFrom(supportEmail);
        mailMessage.setSubject(subject);
        mailMessage.setText(content);      
		
        try
		{
			javaMailSender.send(mailMessage);
		} catch (MailException e)
		{
			logger.error("", e);
		}
	}
	
}
