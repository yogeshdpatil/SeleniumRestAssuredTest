/*
 * Author:  Yogesh Patil
 * Summary: Test Case 3- GET USER details not found
 * Date: 02/15/2021
 */

package com.rest.testcases;

import org.testng.annotations.*;

import com.rest.actions.ValidationActions;
import com.rest.apiconstants.APIEndpointConstants;
import com.rest.base.BaseTest;
import io.restassured.response.Response;

public class TC003_GET_User_Not_Found extends BaseTest {
	private Response response;
	ValidationActions action = new ValidationActions(response);
	
	@BeforeClass
	void testInit() {			//Initialization of test by adding loggers
		logger.info("********* Started TC003_GET_User_Not_Found **********");
	}

	@Test(enabled = true, priority = 1)
	void checkBaseURIForGETUserNotFound() { 		// This method captures response from the
		action					// requested endpoint
			.getAllUserResponse(APIEndpointConstants.GET_SINGLE_USER, 23);
		action.displayGetAllUserResponse();
	}

	@Test(enabled = true, priority = 2)
	void checkResposeBodyForGETUserNotFound() {						//This method verifies response of
		action.verifyUserNotFoundRespose();			//GET user not found API		
	}

	@Test(enabled = true, priority = 3)
	void checkStatusCodeForGETUserNotFound() {			//This method is used to check status code
		action.verifyStatusCode(404); 			//from response
	}

	@AfterClass
	void tearDown() {
		logger.info("*********  Finished TC003_GET_User_Not_Found **********");
	}

}
