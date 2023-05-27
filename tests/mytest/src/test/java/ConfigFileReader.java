
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Arrays;  
import java.util.List;  
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConfigFileReader {
	
	private Properties properties;
    Path path = Paths.get("C:\\Users\\Milan\\source\\repos\\selenium_test\\tests\\mytest\\configs\\properties");
	private final String propertyFilePath= "configs//properties.properties";

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
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}	



	}
	
	public String getDriverPath(){
		String driverPath = properties.getProperty("driver");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");		
	}
	
	public long getWait() {		
		String Wait = properties.getProperty("Wait");
		if(Wait != null) return Long.parseLong(Wait);
		else throw new RuntimeException("Wait not specified in the Configuration.properties file.");		
	}
    public long getImplicitWait() {		
		String ImplicitWait = properties.getProperty("ImplicitWait");
		if(ImplicitWait != null) return Long.parseLong(ImplicitWait);
		else throw new RuntimeException("Wait not specified in the Configuration.properties file.");		
	}
	
	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
    public List<String> getLoadUrls() {
		String [] urls = properties.getProperty("pages").toString().split(",");
        List<String> urlList = Arrays.asList(urls); 
		if(urlList != null) return urlList;
		else throw new RuntimeException("pages not specified in the Configuration.properties file.");
	}
    public String getEmail() {
		String email = properties.getProperty("email");
		if(email != null) return email;
		else throw new RuntimeException("email not specified in the Configuration.properties file.");
	}
    public String getPass() {
		String password = properties.getProperty("password");
		if(password != null) return password;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
}