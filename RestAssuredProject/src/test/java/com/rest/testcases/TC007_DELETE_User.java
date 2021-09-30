/*
 * Author:  Yogesh Patil
 * Summary: Test Case 7- DELETE user details
 * Date: 02/18/2021
 */

/******************************************************
Test Register new record in database 
	URI: https://reqres.in/api/users 
	Request Type: POST
	Request Payload (Body): 
	{
	    "name": "donald",
	    "job": "leader"
	}

********* Validations **********
Response Payload(Body) : 
	{
	    "name": "donald",
	    "job": "leader",
	    "id": "642",
	    "createdAt": "2021-02-16T12:15:56.350Z"
	}

Status Code: 201
Status Line: HTTP/1.1 201 OK
Content Type: application/json

**********************************************************/

package com.rest.testcases;

import org.testng.annotations.*;

import com.rest.actions.ValidationActions;
import com.rest.apiconstants.APIEndpointConstants;
import com.rest.base.BaseTest;
import com.rest.utils.FrameUtility;

import io.restassured.response.Response;

public class TC007_DELETE_User extends BaseTest {
	private Response response;
	ValidationActions action = new ValidationActions(response);

	@BeforeClass
	void testInit() {		//Initialization of test by adding loggers
		logger.info("********* Started TC007_DELETE_User **********");
	}

	@Test(enabled = true, priority = 1)
	void deleteUserRecord() {			//This method is used to delete user record
		action.deleteUserUsingDELETERequest(APIEndpointConstants.DELETE_USER, 2);
	}

	@Test(enabled = true, priority = 2)
	void verifyResponseForDELETERequest() {				 //This method is using to check user 
		action.verifyUserIsDeletedAfterDELETERequest();	 //is deleted or not
	}

	@Test(enabled = true, priority = 3)
	void checkResponseStatusCodeForDELETERequest() {	//This method is used to check status code
		action.verifyStatusCode(204); 					//from response
	}

	@Test(enabled = true, priority = 4)
	void checkStatusLineForDELETERequest() {
		action.verifyStatusLineDetails(FrameUtility					// Comparing status
				.readConfigFileData("TC007_exp_status_line")); 		// line details
	}

	@AfterClass
	void tearDown() {
		logger.info("*********  Finished TC007_DELETE_User **********");
	}

}
