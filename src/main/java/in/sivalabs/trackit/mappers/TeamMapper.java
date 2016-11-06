/**
 * 
 */
package in.sivalabs.trackit.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import in.sivalabs.trackit.domain.Team;

/**
 * @author Siva
 *
 */
@Mapper
public interface TeamMapper 
{

	List<Team> selectTeamsByUserId(@Param("orgId") Integer orgId, @Param("userId") Integer userId);
	
}
