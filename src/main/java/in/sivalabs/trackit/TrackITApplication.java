/**
 *
 */
package in.sivalabs.trackit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import in.sivalabs.trackit.config.TrackITSettings;

/**
 * @author Siva
 *
 */
@SpringBootApplication
@EnableConfigurationProperties(TrackITSettings.class)
public class TrackITApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(TrackITApplication.class, args);
	}

}
