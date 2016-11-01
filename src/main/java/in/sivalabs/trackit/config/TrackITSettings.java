/**
 * 
 */
package in.sivalabs.trackit.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Siva
 *
 */
@ConfigurationProperties(prefix="trackit")
public class TrackITSettings 
{
	private String supportEmail;

	public String getSupportEmail() {
		return supportEmail;
	}

	public void setSupportEmail(String supportEmail) {
		this.supportEmail = supportEmail;
	}
}
