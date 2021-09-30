/*
 * Author:  Yogesh Patil
 * Summary: Test Case 4- POST Create User
 * Date: 02/17/2021
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

public class TC004_POST_Create_User extends BaseTest {
	private Response response;
	ValidationActions action = new ValidationActions(response);

	@BeforeClass
	void testInit() {			//Initialization of test by adding loggers
		logger.info("********* Started TC004_POST_Create_User **********");
	}

	@Test(enabled = true, priority = 1)
	void createUserByPOSTRequest(){
		action.createNewUserUsingPOSTRequest(APIEndpointConstants.CREATE_USER);
	}

	@Test(enabled = true, priority = 2)
	void verifyResponseForPOSTRequest(){
		action.verifyNewlyCreatedUserRespose();
	}

	@Test(enabled = true, priority = 3)
	void checkResponseStatusCodeForPOSTRequest() {		//This method is used to check status code
		action.verifyStatusCode(201); 			//from response
	}

	@Test(enabled = true, priority = 4)
	void checkStatusLineForPOSTRequest() {
		action.verifyStatusLineDetails(FrameUtility					// Comparing status
				.readConfigFileData("TC004_exp_status_line")); 	// line details
	}

	@Test(enabled = true, priority = 5)	
	void checkContentTypeForPOSTRequest() {
		action.verifyContentTypeDetails(FrameUtility				// Comparing contentType
				.readConfigFileData("TC00X_exp_content_type"));  	// details
	}

	@AfterClass
	void tearDown() {
		logger.info("*********  Finished TC004_POST_Create_User **********");
	}

}
