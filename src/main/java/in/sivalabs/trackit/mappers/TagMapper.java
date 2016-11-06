/**
 * 
 */
package in.sivalabs.trackit.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import in.sivalabs.trackit.domain.Tag;

/**
 * @author Siva
 *
 */
@Mapper
public interface TagMapper 
{

	List<Tag> selectTagsByOrgId(@Param("orgId") Integer orgId);
	
}
