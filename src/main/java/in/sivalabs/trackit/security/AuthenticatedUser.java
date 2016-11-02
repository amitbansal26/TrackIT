/**
 * 
 */
package in.sivalabs.trackit.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import in.sivalabs.trackit.domain.User;

/**
 * @author Siva
 *
 */
public class AuthenticatedUser extends org.springframework.security.core.userdetails.User
{

	private static final long serialVersionUID = 1L;
	private User user;
	
	public AuthenticatedUser(User user)
	{
		super(user.getEmail(), user.getPassword(), getAuthorities(user));
		this.user = user;
	}
	
	public User getUser()
	{
		return user;
	}
	
	private static Collection<? extends GrantedAuthority> getAuthorities(User user)
	{
		Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_USER");
		return authorities;
	}
}
