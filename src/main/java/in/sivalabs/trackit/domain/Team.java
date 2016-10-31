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
public class Team
{
	private Integer id;
	private Integer orgId;
	private String name;
	private List<User> members = new ArrayList<>(0);
	
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public Integer getOrgId()
	{
		return orgId;
	}
	public void setOrgId(Integer orgId)
	{
		this.orgId = orgId;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public List<User> getMembers()
	{
		return members;
	}
	public void setMembers(List<User> members)
	{
		this.members = members;
	}
	
	
}
