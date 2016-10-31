/**
 * 
 */
package in.sivalabs.trackit.domain;

/**
 * @author Siva
 *
 */
public class Project
{
	private Integer id;
	private Integer orgId;
	private String name;
	
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
	
}
