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
public class Organization extends BaseDomain
{
	private Integer id;
	private String name;
	private User owner;
	private List<User> members = new ArrayList<>(0);
	private List<Team> teams = new ArrayList<>(0);
	private List<Tag> tags = new ArrayList<>(0);
	
	
	@Override
	public String toString()
	{
		return "Organization [id=" + id + ", name=" + name + ", owner=" + owner + ", members=" + members + ", teams="
				+ teams + ", tags=" + tags + "]";
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
	public User getOwner()
	{
		return owner;
	}
	public void setOwner(User owner)
	{
		this.owner = owner;
	}
	public List<User> getMembers()
	{
		return members;
	}
	public void setMembers(List<User> members)
	{
		this.members = members;
	}
	public List<Team> getTeams()
	{
		return teams;
	}
	public void setTeams(List<Team> teams)
	{
		this.teams = teams;
	}
	public List<Tag> getTags()
	{
		return tags;
	}
	public void setTags(List<Tag> tags)
	{
		this.tags = tags;
	}
}
