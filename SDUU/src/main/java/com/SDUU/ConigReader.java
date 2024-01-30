package com.SDUU;

public class ConigReader {
	
private ConigReader() {	
	}
	
	public static ConfigHelper getInstance() throws Exception {
		ConfigHelper helper = new ConfigHelper();
		return helper;
	}

}
