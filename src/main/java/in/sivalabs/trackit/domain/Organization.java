/**
 * 
 */
package in.sivalabs.trackit.domain;

/**
 * @author Siva
 *
 */
public class Organization
{
	private Integer id;
	private String name;
	private Integer adminUserId;
	
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
	public Integer getAdminUserId()
	{
		return adminUserId;
	}
	public void setAdminUserId(Integer adminUserId)
	{
		this.adminUserId = adminUserId;
	}	
}
