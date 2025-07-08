package PropertyPackage;
import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
public class PropertyReaderClass {

	public static String getBaseUri(String baseUri) throws IOException
	{
		Properties property=new Properties();
		FileInputStream fis=new FileInputStream("D:\\Maven and Cucumber Projects\\Amazon_Cucumber\\SpotifyAPI\\src\\test\\resources\\ConfigPackage\\config.properties");
	
		property.load(fis);
		String propvalue=property.getProperty(baseUri);
		return propvalue;
	}
	public static String getBasePath(String basePath) throws IOException
	{
		Properties property=new Properties();
		
		FileInputStream fis=new FileInputStream("D:\\Maven and Cucumber Projects\\Amazon_Cucumber\\SpotifyAPI\\src\\test\\resources\\ConfigPackage\\config.properties");
		property.load(fis);
		String propvalue=property.getProperty(basePath);
		return propvalue;
	}
	public static String getClientId(String client_id) throws IOException
	{
		Properties property=new Properties();
		FileInputStream fis=new FileInputStream("D:\\Maven and Cucumber Projects\\Amazon_Cucumber\\SpotifyAPI\\src\\test\\resources\\ConfigPackage\\config.properties");
		property.load(fis);
		String propvalue=property.getProperty(client_id);
		return propvalue;
	}
	public static String getClientSecrete(String client_secrete) throws IOException
	{
		Properties property=new Properties();
		FileInputStream fis=new FileInputStream("D:\\Maven and Cucumber Projects\\Amazon_Cucumber\\SpotifyAPI\\src\\test\\resources\\ConfigPackage\\config.properties");
		property.load(fis);
		String propvalue=property.getProperty(client_secrete);
		return propvalue;
	}
	public static String getRefreshToken(String refresh_token) throws IOException
	{
		Properties property=new Properties();
		FileInputStream fis=new FileInputStream("D:\\Maven and Cucumber Projects\\Amazon_Cucumber\\SpotifyAPI\\src\\test\\resources\\ConfigPackage\\config.properties");
		property.load(fis);
		String propvalue=property.getProperty(refresh_token);
		return propvalue;
	}
	
}
