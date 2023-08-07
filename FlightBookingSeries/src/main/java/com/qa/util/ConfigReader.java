package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigReader {

	private Properties prop;
	
	/**
	 * Getting properties from property file
	 */
	
	public Properties init_prop() {
		prop = new Properties();
		try {
		FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
		prop.load(ip);
		
	}catch(Exception e) {
		e.printStackTrace();
	}
		return prop;
	}
	
}
