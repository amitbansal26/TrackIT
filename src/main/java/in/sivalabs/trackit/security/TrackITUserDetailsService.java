/**
 * 
 */
package in.sivalabs.trackit.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.sivalabs.trackit.domain.User;
import in.sivalabs.trackit.services.UserService;

/**
 * @author Siva
 *
 */
@Service
@Transactional
public class TrackITUserDetailsService implements UserDetailsService
{
	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		User user = userService.findUserByEmail(userName);
		if(user == null){
			throw new UsernameNotFoundException("Email "+userName+" not found");
		}
		return new AuthenticatedUser(user);
	}

}
