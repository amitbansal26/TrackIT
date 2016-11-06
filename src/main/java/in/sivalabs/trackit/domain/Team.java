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
public class Team extends BaseDomain
{
	private Integer id;
	private String name;
	private Organization organization;
	private List<User> members = new ArrayList<>(0);
	private List<Project> projects = new ArrayList<>(0);
	
	@Override
	public String toString()
	{
		return "Team [id=" + id + ", name=" + name + ", organization=" + organization + ", members=" + members
				+ ", projects=" + projects + "]";
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
	public Organization getOrganization()
	{
		return organization;
	}
	public void setOrganization(Organization organization)
	{
		this.organization = organization;
	}
	public List<User> getMembers()
	{
		return members;
	}
	public void setMembers(List<User> members)
	{
		this.members = members;
	}
	public List<Project> getProjects()
	{
		return projects;
	}
	public void setProjects(List<Project> projects)
	{
		this.projects = projects;
	}

}
