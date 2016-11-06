/**
 * 
 */
package in.sivalabs.trackit.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Siva
 *
 */
public class User extends BaseDomain
{
	private Integer id;
	private String name;
	private String email;
	private String password;
	private boolean enabled;
	private boolean locked;
	private String activationToken;
	private String forgotPasswordToken;
	private List<Organization> organizations = new ArrayList<>(0);

	@Override
	public String toString()
	{
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", enabled=" + enabled + ", locked=" + locked
				+ "]";
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public boolean isEnabled()
	{
		return enabled;
	}

	public void setEnabled(boolean enabled)
	{
		this.enabled = enabled;
	}

	public boolean isLocked()
	{
		return locked;
	}

	public void setLocked(boolean locked)
	{
		this.locked = locked;
	}

	public String getActivationToken()
	{
		return activationToken;
	}

	public void setActivationToken(String activationToken)
	{
		this.activationToken = activationToken;
	}

	public String getForgotPasswordToken()
	{
		return forgotPasswordToken;
	}

	public void setForgotPasswordToken(String forgotPasswordToken)
	{
		this.forgotPasswordToken = forgotPasswordToken;
	}

	public List<Organization> getOrganizations()
	{
		return organizations;
	}

	public void setOrganizations(List<Organization> organizations)
	{
		this.organizations = organizations;
	}
	
}
