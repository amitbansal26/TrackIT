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
public class TagsController extends BaseController
{
	
	@GetMapping("/tags")
	public String tags()
	{
		return "tags";
	}
}
