/**
 * 
 */
package in.sivalabs.trackit.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import in.sivalabs.trackit.domain.Project;

/**
 * @author Siva
 *
 */
@Mapper
public interface ProjectMapper 
{

	List<Project> selectProjectsByUserIdAndOrgId(Integer userId);
	
}
