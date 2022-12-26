package Com.Banking.Configurations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfiguration {

	Properties pro;

	public ReadConfiguration() {

		File src = new File(
				"/Users/ranjeetkendre/Desktop/23July_Automation_Framework/src/main/java/Com/Banking/Configurations/Config.properties");

		FileInputStream fis;

		try {
			fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is :" + e.getMessage());
		}
					
		}
	
	public String getApplicationURL() {
     String url = pro.getProperty("baseURl");	
     return url;
	}
	
	public String getUsername() {
		String username =pro.getProperty("username");	
	     return username;
	}
	public String getPassword() {
		String password =pro.getProperty("password");	
	     return password;
	}
	public String getChromepath() {
		String chromepath =pro.getProperty("chromepath");	
	     return chromepath;
	}
	public String getFirefoxpath() {
		String Firefox =pro.getProperty("Firefoxpath");	
	     return Firefox;
	}
	
	
}
