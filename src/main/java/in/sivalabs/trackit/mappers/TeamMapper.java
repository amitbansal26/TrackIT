/**
 * 
 */
package in.sivalabs.trackit.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import in.sivalabs.trackit.domain.Team;

/**
 * @author Siva
 *
 */
@Mapper
public interface TeamMapper 
{

	List<Team> selectTeamsByUserId(Integer orgId, Integer userId);
	
}
