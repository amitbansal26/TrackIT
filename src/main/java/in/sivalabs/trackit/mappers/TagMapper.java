/**
 * 
 */
package in.sivalabs.trackit.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import in.sivalabs.trackit.domain.Tag;

/**
 * @author Siva
 *
 */
@Mapper
public interface TagMapper 
{

	List<Tag> selectTagsByUserId(Integer orgId, Integer userId);
	
}
