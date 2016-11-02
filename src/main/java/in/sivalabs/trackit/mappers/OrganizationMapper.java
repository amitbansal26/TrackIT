/**
 * 
 */
package in.sivalabs.trackit.mappers;

import org.apache.ibatis.annotations.Mapper;

import in.sivalabs.trackit.domain.Organization;

/**
 * @author Siva
 *
 */
@Mapper
public interface OrganizationMapper 
{

	Organization selectOrganizationById(Integer organizationId);
	
}
