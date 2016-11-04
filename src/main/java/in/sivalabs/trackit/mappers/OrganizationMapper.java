/**
 * 
 */
package in.sivalabs.trackit.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import in.sivalabs.trackit.domain.Organization;

/**
 * @author Siva
 *
 */
@Mapper
public interface OrganizationMapper 
{

	boolean isOrganizationNameExists(String organizationName);
	
	Organization selectOrganizationById(Integer organizationId);

	List<Organization> selectOrganizationsByUserId(Integer userId);
	
}
