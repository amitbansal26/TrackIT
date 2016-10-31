/**
 * 
 */
package in.sivalabs.trackit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.sivalabs.trackit.domain.User;
import in.sivalabs.trackit.mappers.UserMapper;

/**
 * @author Siva
 *
 */
@Service
@Transactional(readOnly=true)
public class UserService 
{
	private UserMapper userMapper;
	
	@Autowired
	public UserService(UserMapper userMapper) 
	{
		this.userMapper= userMapper;
	}
	
	public User findUserById(Integer id)
	{
		return this.userMapper.selectUserById(id);
	}
	
	
}
