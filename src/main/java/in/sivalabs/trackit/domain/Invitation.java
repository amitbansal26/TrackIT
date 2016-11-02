/**
 * 
 */
package in.sivalabs.trackit.domain;

/**
 * @author Siva
 *
 */
public class Invitation extends BaseDomain
{
	private Integer id;
	private String fromEmail;
	private String toEmail;
	private Organization organization;
	private String invitationCode;
	private boolean accepted;
	
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public String getFromEmail()
	{
		return fromEmail;
	}
	public void setFromEmail(String fromEmail)
	{
		this.fromEmail = fromEmail;
	}
	public String getToEmail()
	{
		return toEmail;
	}
	public void setToEmail(String toEmail)
	{
		this.toEmail = toEmail;
	}
	public Organization getOrganization()
	{
		return organization;
	}
	public void setOrganization(Organization organization)
	{
		this.organization = organization;
	}
	public String getInvitationCode()
	{
		return invitationCode;
	}
	public void setInvitationCode(String invitationCode)
	{
		this.invitationCode = invitationCode;
	}
	public boolean isAccepted()
	{
		return accepted;
	}
	public void setAccepted(boolean accepted)
	{
		this.accepted = accepted;
	}
	
}
