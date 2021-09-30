/*
 * Author: Yogesh Patil
 * Summary: This is a test base class created for setting up log4j setup
 * 			which will be used throughout the framework.	
 * Date: 02/15/2021
 */

package com.rest.base;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import com.rest.apiconstants.APIEndpointConstants;

public class BaseTest {
	protected Logger logger;

	@BeforeClass
	public void setup() {
		logger = Logger.getLogger("Practise API");				// added Logger
		PropertyConfigurator.configure(APIEndpointConstants.LOG4J_FILE_PATH); 	// added logger
		logger.setLevel(Level.DEBUG);
	}
}
