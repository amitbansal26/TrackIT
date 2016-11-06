/**
 * 
 */
package in.sivalabs.trackit.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import in.sivalabs.trackit.model.UserProfile;
import in.sivalabs.trackit.security.AuthenticatedUser;
import in.sivalabs.trackit.services.UserService;

/**
 * @author Siva
 *
 */
@Controller
public class HomeController extends BaseController
{
	@Autowired
    private UserService userService;
	
	@GetMapping("/")
	public String index()
	{
		boolean loggedIn = isLoggedIn();
		if(loggedIn){
			return "redirect:/home";
		} else {
			return "redirect:/login";			
		}
	}
	
	@GetMapping("/home")
	public String home(Model model)
	{
		AuthenticatedUser authenticatedUser = getCurrentUser();
		String email = authenticatedUser.getUsername();
		UserProfile userProfile = userService.getUserProfile(email);
		model.addAttribute("userProfile", userProfile);
		return "home";
	}
}
