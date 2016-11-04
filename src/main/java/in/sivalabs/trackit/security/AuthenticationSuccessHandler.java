/**
 * 
 */
package in.sivalabs.trackit.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import in.sivalabs.trackit.model.UserProfile;
import in.sivalabs.trackit.services.UserService;

/**
 * @author Siva
 *
 */
@Component
public class AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler
{
    @Autowired
    private UserService userService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException
	{
		if(authentication instanceof AuthenticatedUser)
		{
			AuthenticatedUser authenticatedUser = (AuthenticatedUser) authentication;
			String email = authenticatedUser.getUsername();
			UserProfile userProfile = userService.getUserProfile(email);
			request.getSession().setAttribute("USER_PROFILE_KEY", userProfile);
		}
		super.onAuthenticationSuccess(request, response, authentication);
	}

}
