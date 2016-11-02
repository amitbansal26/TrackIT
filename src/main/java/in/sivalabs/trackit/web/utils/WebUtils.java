/**
 * 
 */
package in.sivalabs.trackit.web.utils;

import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author Siva
 *
 */
public class WebUtils 
{
	private static final Logger logger = LoggerFactory.getLogger(WebUtils.class);
	
	public static String getRootURL() 
	{
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		if(null != requestAttributes && requestAttributes instanceof ServletRequestAttributes) {
		  HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
		  return getURLWithContextPath(request);
		}
		else {
		  return "http://localhost:8080/";
		}
	}
	
	public static String getURLWithContextPath(HttpServletRequest request) 
	{
		try 
		{
			URL requestURL = new URL(request.getRequestURL().toString());
			String port = requestURL.getPort() == -1 ? "" : ":" + requestURL.getPort();
			return requestURL.getProtocol() + "://" + requestURL.getHost() + port;
		} catch (MalformedURLException e) 
		{
			logger.error(e.getMessage(), e);
			return  request.getScheme() + "://" + 
					request.getServerName() + ":" + 
					request.getServerPort() + 
					request.getContextPath();
		}
	}

}
