package amazon.test.dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ConfigFileReader {
	private Properties properties;
	private final String propertyFilePath= "src/test/resources/config.properties";
	static Logger logger = Logger.getLogger(ConfigFileReader.class);
	
	public ConfigFileReader(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("config.properties not found at " + propertyFilePath);
		}		
	}
	
	public String getDriverPath(){
		String driverPath = properties.getProperty("driverPath");
		if(driverPath!= null) return driverPath;
		else {
			logger.error("driverPath not specified in the config.properties file.");
			throw new RuntimeException("driverPath not specified in the config.properties file.");		
		}
	}
	
	public long getImplicitlyWait() {		
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
		else {
			logger.error("implicitlyWait not specified in the config.properties file.");
			throw new RuntimeException("implicitlyWait not specified in the config.properties file.");		
		}
	}
	
	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if(url != null) return url;
		else {
			logger.error("url not specified in the config.properties file.");
			throw new RuntimeException("url not specified in the config.properties file.");		
		}
	}
	
	public String getBrowser(){
		String browser = properties.getProperty("browser");
		if(browser!= null) return browser;
		else {
			logger.error("browser not specified in the config.properties file.");
			throw new RuntimeException("browser not specified in the config.properties file.");		
		}
	}
	
	public String getUserId(){
		String userId = properties.getProperty("userId");
		if(userId!= null) return userId;
		else {
			logger.error("userId not specified in the config.properties file.");
			throw new RuntimeException("userId not specified in the config.properties file.");		
		}
	}
	
	public String getPassword(){
		String password = properties.getProperty("password");
		if(password!= null) return password;
		else {
			logger.error("password not specified in the config.properties file.");
			throw new RuntimeException("password not specified in the config.properties file.");		
		}
	}
}
