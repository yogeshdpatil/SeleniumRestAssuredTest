/*
 * Author:  Yogesh Patil
 * Summary: Test Case 5- PUT- UPDATE user details
 * Date: 02/18/2021
 */

package com.rest.testcases;

import org.testng.annotations.*;

import com.rest.actions.ValidationActions;
import com.rest.apiconstants.APIEndpointConstants;
import com.rest.base.BaseTest;
import com.rest.utils.FrameUtility;

import io.restassured.response.Response;

public class TC005_PUT_Update_User extends BaseTest {
	private Response response;
	ValidationActions action = new ValidationActions(response);
	
	@BeforeClass
	void testInit() {		//Initialization of test by adding loggers
		logger.info("********* Started TC005_PUT_Update_User_Details **********");
	}

	@Test(enabled = true, priority = 1)
	void userUpdateWithPUTRequest(){		
		action.updateUserDetailsUsingPUTRequest(APIEndpointConstants.UPDATE_USER, 2);
	}

	@Test(enabled = true, priority = 2)
	void verifyResponseForPUTRequest(){
		action.verifyUserIsUpdatedAfterPUTRequest();
	}
		
	@Test(enabled = true, priority = 3)
	void checkResponseStatusCodeForPUTRequest() {		//This method is used to check status code
		action.verifyStatusCode(200); 					//from response
	}

	@Test(enabled = true, priority = 4)
	void checkStatusLineForPUTRequest() {
		action.verifyStatusLineDetails(FrameUtility					// Comparing status
				.readConfigFileData("TC005_exp_status_line")); 		// line details
	}

	@Test(enabled = true, priority = 5)	
	void checkContentTypeForPUTRequest() {
		action.verifyContentTypeDetails(FrameUtility				// Comparing contentType
				.readConfigFileData("TC00X_exp_content_type"));  	// details
	}

	@AfterClass
	void tearDown() {
		logger.info("*********  Finished TC005_PUT_Update_User_Details **********");
	}

}
