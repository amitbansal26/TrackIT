/**
 * 
 */
package in.sivalabs.trackit.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Siva
 *
 */
@Controller
public class HomeController extends BaseController
{
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
	public String home()
	{
		return "home";
	}
}
