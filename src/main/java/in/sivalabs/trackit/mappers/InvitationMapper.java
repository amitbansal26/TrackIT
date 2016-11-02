/**
 * 
 */
package in.sivalabs.trackit.mappers;

import org.apache.ibatis.annotations.Mapper;

import in.sivalabs.trackit.domain.Invitation;

/**
 * @author Siva
 *
 */
@Mapper
public interface InvitationMapper 
{

	void insertInvitation(Invitation invitation);

}
