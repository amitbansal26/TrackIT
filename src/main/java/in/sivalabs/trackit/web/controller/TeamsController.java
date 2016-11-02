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
public class TeamsController extends BaseController
{
	
	@GetMapping("/teams")
	public String teams()
	{
		return "teams";
	}
}
