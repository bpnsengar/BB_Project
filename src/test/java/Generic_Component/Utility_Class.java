package Generic_Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Utility_Class {

	public String reading_properties(String skeys) throws IOException{
		FileInputStream fis = new FileInputStream("BB.properties");
		Properties property = new Properties();
		property.load(fis);
		
		return property.getProperty(skeys);
	}
}
