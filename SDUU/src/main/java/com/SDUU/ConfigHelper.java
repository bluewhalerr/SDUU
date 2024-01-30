package com.SDUU;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigHelper {
	
	public static Properties p;
	
	public ConfigHelper() throws Exception {
	
	File file = new File (".\\src\\test\\resources\\com\\SDUU\\config\\TestData.properties");
	
	FileInputStream fis = new FileInputStream(file);
	
	p = new Properties();
	p.load(fis);
	}
	
	public static String getProperty(String value) {
		String property = p.getProperty(value);
		return property;
	}

}


