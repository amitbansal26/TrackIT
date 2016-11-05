/**
 * 
 */
package in.sivalabs.trackit.domain;

/**
 * @author Siva
 *
 */
public class Tag extends BaseDomain
{
	private Integer id;
	private String name;
	private Organization organization;

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

}
