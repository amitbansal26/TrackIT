/**
 * 
 */
package in.sivalabs.trackit.model;

import java.util.ArrayList;
import java.util.List;

import in.sivalabs.trackit.domain.Organization;

/**
 * @author Siva
 *
 */
public class UserProfile
{
	private Integer id;
	private String name;
	private String email;
	private Organization selectedOrganization;
	private List<Organization> organizations = new ArrayList<>(0);
	
	@Override
	public String toString()
	{
		return "UserProfile [id=" + id + ", name=" + name + ", email=" + email + ", selectedOrganization="
				+ selectedOrganization + ", organizations=" + organizations + "]";
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
	public Organization getSelectedOrganization()
	{
		return selectedOrganization;
	}
	public void setSelectedOrganization(Organization selectedOrganization)
	{
		this.selectedOrganization = selectedOrganization;
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
