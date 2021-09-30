/*
 * Author:  Yogesh Patil
 * Summary: Test Case 6- PATCH- PARTIAL user details update
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

public class TC006_PATCH_Partial_User_Update extends BaseTest {
	private Response response;
	ValidationActions action = new ValidationActions(response);

	@BeforeClass
	void testInit() {		//Initialization of test by adding loggers
		logger.info("********* Started TC006_Partial_Update_in_User_Info **********");
	}

	@Test(enabled = true, priority = 1)
	void partialUserUpdateWithPATCHRequest(){
		action.partialUpdateUserUsingPATCHRequest(APIEndpointConstants.UPDATE_USER, 2);
	}

	@Test(enabled = true, priority = 2)
	void verifyResponseForPATCHRequest(){
		action.verifyUserIsUpdatedAfterPATCHRequest();
	}

	@Test(enabled = true, priority = 3)
	void checkResponseStatusCodeForPATCHRequest() {		//This method is used to check status code
		action.verifyStatusCode(200); 					//from response
	}

	@Test(enabled = true, priority = 4)
	void checkStatusLineForPATCHRequest() {
		action.verifyStatusLineDetails(FrameUtility					// Comparing status
				.readConfigFileData("TC005_exp_status_line")); 		// line details
	}

	@Test(enabled = true, priority = 5)
	void checkContentTypeForPATCHRequest() {
		action.verifyContentTypeDetails(FrameUtility				// Comparing contentType
				.readConfigFileData("TC00X_exp_content_type"));  	// details
	}

	@AfterClass
	void tearDown() {
		logger.info("*********  TC006_Partial_Update_in_User_Info **********");
	}

}
