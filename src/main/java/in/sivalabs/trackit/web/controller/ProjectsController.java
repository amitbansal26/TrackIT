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
public class ProjectsController extends BaseController
{
	
	@GetMapping("/projects")
	public String projects()
	{
		return "projects";
	}
}
