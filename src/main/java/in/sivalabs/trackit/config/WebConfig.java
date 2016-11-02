/**
 * 
 */
package in.sivalabs.trackit.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

/**
 * @author Siva
 *
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter
{   
	
	@Autowired
    private MessageSource messageSource;

    @Override
    public Validator getValidator() {
        LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean();
        factory.setValidationMessageSource(messageSource);
        return factory;
    }
    	
	@Override
	public void addViewControllers(ViewControllerRegistry registry)
	{
		super.addViewControllers(registry);
        registry.addViewController("/login").setViewName("public/login");
		//registry.addRedirectViewController("/", "/home");
		
	}
	/*
	@Bean
	public SpringSecurityDialect securityDialect() {
	    return new SpringSecurityDialect();
	}
	*/
	@Bean 
	public ClassLoaderTemplateResolver emailTemplateResolver(){ 
		ClassLoaderTemplateResolver emailTemplateResolver = new ClassLoaderTemplateResolver(); 
		emailTemplateResolver.setPrefix("email-templates/"); 
		emailTemplateResolver.setSuffix(".html"); 
		emailTemplateResolver.setTemplateMode("HTML5"); 
		emailTemplateResolver.setCharacterEncoding("UTF-8"); 
		emailTemplateResolver.setOrder(2);
		
		return emailTemplateResolver; 
	}
	
}
