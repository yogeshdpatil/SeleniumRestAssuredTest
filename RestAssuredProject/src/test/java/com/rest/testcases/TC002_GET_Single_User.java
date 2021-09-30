/*
 * Author:  Yogesh Patil
 * Summary: Test Case 2- GET SINGLE USER details from user list
 * Date: 02/15/2021
 */

package com.rest.testcases;

import org.testng.annotations.*;

import com.rest.actions.ValidationActions;
import com.rest.apiconstants.APIEndpointConstants;
import com.rest.base.BaseTest;
import com.rest.utils.FrameUtility;

import io.restassured.response.Response;

public class TC002_GET_Single_User extends BaseTest {
	private Response response;
	ValidationActions action = new ValidationActions(response);

	@BeforeClass
	void testInit() { 		// Initialization of test by adding loggers
		logger.info("********* Started TC002_GET_Single_User_Details **********");
	}

	@Test(enabled = true, priority = 1)
	void checkBaseURIForGETSingleRequest() { 		// This method captures response from the
		action					// requested endpoint
			.getAllUserResponse(APIEndpointConstants.GET_SINGLE_USER, 7);
		action.displayGetAllUserResponse();
	}
		
	@Test(enabled = true, priority = 2)
	void checkResposeBodyForGETSingleRequest() {						//This method verifies response of
		action.verifyGetUserRespose();				//getSingleUser API		
	}
	
	@Test(enabled = true, priority = 3)
	void checkStatusCodeForGETSingleRequest() {			//This method is used to check status code
		action.verifyStatusCode(200); 			//from response
	}

	@Test(enabled = true, priority = 4)
	void checkStatusLineForGETSingleRequest() {
		action.verifyStatusLineDetails(FrameUtility					// Comparing status
				.readConfigFileData("TC001_2_exp_status_line")); 	// line details
	}

	@Test(enabled = true, priority = 5)
	void checkContentTypeForGETSingleRequest() {
		action.verifyContentTypeDetails(FrameUtility				// Comparing contentType
				.readConfigFileData("TC00X_exp_content_type"));  	// details
	}
	
	@AfterClass
	void tearDown() {
		logger.info("*********  Finished TC002_Get_Single_User_Details **********");
	}

}
