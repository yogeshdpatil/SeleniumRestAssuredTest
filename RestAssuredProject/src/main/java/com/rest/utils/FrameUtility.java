package com.rest.utils;

import java.io.FileInputStream;
import java.util.Properties;

import com.rest.apiconstants.APIEndpointConstants;

public class FrameUtility {
	private static Properties prop;	
	
	public static String readConfigFileData(String key) {
		try {
			prop = new Properties();
			prop.load(new FileInputStream(APIEndpointConstants.CONFIG_FILE_PATH ));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Cannot find key: "+key+" in Config file due to exception : "+e);			
		}
		return prop.getProperty(key);		
	}
}
