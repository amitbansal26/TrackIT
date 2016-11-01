/**
 * 
 */
package in.sivalabs.trackit.mappers;

import org.apache.ibatis.annotations.Mapper;

import in.sivalabs.trackit.domain.User;

/**
 * @author Siva
 *
 */
@Mapper
public interface UserMapper 
{
	User selectUserById(Integer id);

	boolean isEmailExists(String email);

	void insertUser(User user);
}
