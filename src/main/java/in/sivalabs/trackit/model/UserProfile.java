/**
 * 
 */
package in.sivalabs.trackit.model;

import java.util.ArrayList;
import java.util.List;

import in.sivalabs.trackit.domain.Organization;
import in.sivalabs.trackit.domain.Tag;
import in.sivalabs.trackit.domain.Team;

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
	private List<Team> teams = new ArrayList<>(0);
	private List<Tag> tags = new ArrayList<>(0);
	
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
	public List<Team> getTeams()
	{
		return teams;
	}
	public void setTeams(List<Team> teams)
	{
		this.teams = teams;
	}
	/*public List<Project> getProjects()
	{
		return projects;
	}
	public void setProjects(List<Project> projects)
	{
		this.projects = projects;
	}*/
	public List<Tag> getTags()
	{
		return tags;
	}
	public void setTags(List<Tag> tags)
	{
		this.tags = tags;
	}
	
}
