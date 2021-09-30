/*
 * Author:  Yogesh Patil
 * Summary: Test Case 1- GET USER LIST
 * Date: 02/15/2021
 */

package com.rest.testcases;

import org.testng.annotations.*;

import com.rest.actions.ValidationActions;
import com.rest.apiconstants.APIEndpointConstants;
import com.rest.base.BaseTest;
import com.rest.utils.FrameUtility;

import io.restassured.response.Response;

public class TC001_GET_List_of_Users extends BaseTest {
	private Response response;
	ValidationActions action = new ValidationActions(response);

	@BeforeClass
	void testInit() {		//Initialization of test by adding loggers
		logger.info("********* Started TC001_GET_User_List **********");
	}

	@Test(enabled = true, priority = 1)
	void checkBaseURIForGETAllRequest() {					//This method captures response from the
		action.							//requested endpoint
			getAllUserResponse(APIEndpointConstants.GET_ALL_USERS);		
		action.displayGetAllUserResponse();
	}

	@Test(enabled = true, priority = 2)
	void checkAllUsersResponseForGETRequest() {			//This method verifies response of
		action.verifyGetUserRespose();		//getAlluser API
	}

	@Test(enabled = true, priority = 3)
	void checkStatusCodeForGETAllUserRequest() {		//This method is used to check status code
		action.verifyStatusCode(200); 		//from response
	}

	@Test(enabled = true, priority = 4)
	void checkStatusLineForGETAllUserRequest() {
		action.verifyStatusLineDetails(FrameUtility					// Comparing status
				.readConfigFileData("TC001_2_exp_status_line")); 	// line details
	}

	@Test(enabled = true, priority = 5)
	void checkContentTypeForGETAllUserRequest() {
		action.verifyContentTypeDetails(FrameUtility				// Comparing contentType
				.readConfigFileData("TC00X_exp_content_type"));  	// details
	}

	@AfterClass
	void tearDown() {		//End of the test by adding loggers
		logger.info("*********  Finished TC001_Get_Users_List **********");
	}

}
