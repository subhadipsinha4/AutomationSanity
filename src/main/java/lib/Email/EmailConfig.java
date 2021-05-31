package lib.Email;

import lib.UnbxdFileUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EmailConfig {
	
	public static Properties CONFIG;
	
	public EmailConfig() throws IOException {
		CONFIG = new Properties();
		FileInputStream fs = new FileInputStream(
				UnbxdFileUtils.getFilePathInResources("email_config.properties"));
		CONFIG.load(fs);
	}
	
	//************* GET EMAIL PROPERTIES *******************

	  public String getEmailAddressFromProperties(){
	    return CONFIG.getProperty("email.address");
	  }

	  public String getEmailUsernameFromProperties(){
	    return CONFIG.getProperty("email.username");
	  }

	  public String getEmailPasswordFromProperties(){
	    return CONFIG.getProperty("email.password");
	  }

	  public String getEmailProtocolFromProperties(){
	    return CONFIG.getProperty("email.protocol");
	  }

	  public int getEmailPortFromProperties(){
	    return Integer.parseInt(CONFIG.getProperty("email.port"));
	  }

	  public String getEmailServerFromProperties(){
	    return CONFIG.getProperty("mail.smtp.host");
	  }

}
