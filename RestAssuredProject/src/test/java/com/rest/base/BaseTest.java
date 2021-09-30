/*
 * Author: Yogesh Patil
 * Summary: This is a test base class created for setting up log4j setup
 * 			which will be used throughout the framework.	
 * Date: 02/15/2021
 */

package com.rest.base;

import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	protected Logger logger;

	@BeforeClass
	public void setup() {
		logger = (Logger) LogManager.getLogger(BaseTest.class);	  // added Logger
		// PropertyConfigurator.configure(APIEndpointConstants.LOG4J_FILE_PATH); 	// added logger
		// logger.setLevel(Level.DEBUG);
	}
}
