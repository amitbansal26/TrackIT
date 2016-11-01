/**
 * 
 */
package in.sivalabs.trackit.domain;

import java.util.Date;

/**
 * @author Siva
 *
 */
public abstract class BaseDomain
{
	protected Integer createdBy;
	protected Date createdDate = new Date();
	protected Integer updatedBy;
	protected Date updatedDate;
	
	public Integer getCreatedBy()
	{
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy)
	{
		this.createdBy = createdBy;
	}
	public Date getCreatedDate()
	{
		return createdDate;
	}
	public void setCreatedDate(Date createdDate)
	{
		this.createdDate = createdDate;
	}
	public Integer getUpdatedBy()
	{
		return updatedBy;
	}
	public void setUpdatedBy(Integer updatedBy)
	{
		this.updatedBy = updatedBy;
	}
	public Date getUpdatedDate()
	{
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate)
	{
		this.updatedDate = updatedDate;
	}
	
	
}
