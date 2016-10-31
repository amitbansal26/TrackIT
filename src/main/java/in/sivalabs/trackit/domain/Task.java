/**
 * 
 */
package in.sivalabs.trackit.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Siva
 *
 */
public class Task
{
	private Integer id;
	private Integer projId;
	private String name;
	private String description;
	private Integer assignedUserId;
	private Date dueDate;
	private List<Tag> tags = new ArrayList<>(0);
	
	private Integer createdBy;
	private Date createdDate;
	private Integer updatedBy;
	private Date updatedDate;
	
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public Integer getProjId()
	{
		return projId;
	}
	public void setProjId(Integer projId)
	{
		this.projId = projId;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public Integer getAssignedUserId()
	{
		return assignedUserId;
	}
	public void setAssignedUserId(Integer assignedUserId)
	{
		this.assignedUserId = assignedUserId;
	}
	public Date getDueDate()
	{
		return dueDate;
	}
	public void setDueDate(Date dueDate)
	{
		this.dueDate = dueDate;
	}
	public List<Tag> getTags()
	{
		return tags;
	}
	public void setTags(List<Tag> tags)
	{
		this.tags = tags;
	}
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
