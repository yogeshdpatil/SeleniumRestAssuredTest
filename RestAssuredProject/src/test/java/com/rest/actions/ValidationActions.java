/*
 * Author: Yogesh Patil
 * Summary: This is a actions class created for maintaining
 * 			all common REST API methods which will be used 
 * 			throughout the framework.	
 * Date: 02/23/2021
 */

package com.rest.actions;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.testng.Assert;

import com.rest.apiconstants.APIEndpointConstants;
import com.rest.utils.FrameUtility;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ValidationActions{	
	public Response response = null;	//Initialised response instance
	
	public ValidationActions(Response rresponse){	//Constructor added for this class
		this.response = rresponse;					//to assign response value
	}	
	
	/* "getAllUserResponse()" method is created to GET and
	 * validate response for all users 
	 */
	public void getAllUserResponse(String endpointURI) {			
		response = 
			given()
				.get(APIEndpointConstants.BASE_URI + endpointURI)
			.then()
				.log().all()
				.extract()
				.response();			
	}
	
	/* "getAllUserResponse()" method with different sigature is created to GET and
	 * validate response for user with specific ID. 
	 * Method overloading is achieved here. 
	 */
	public void getAllUserResponse(String endpointURI, int ID) {			
		response = 
		given()
			.pathParam("id", ID)
			.get(APIEndpointConstants.BASE_URI + endpointURI)
		.then()
			.log().all()
			.extract()
			.response();			
	}
	
	/* "displayGetAllUserResponse()" method is created to print 
	 * all users response
	 */
	public void displayGetAllUserResponse() {
		System.out.println(response.getBody().asString());
		System.out.println(response.contentType());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getTime());		
	}	
	
	/* "verifyGetUserRespose()" method is created to validate
	 * user response captured in earlier method.
	 */
	public void verifyGetUserRespose() {
		String responseBody = response.getBody().asString();
		System.out.println("responseBody is :" + responseBody);
		Assert.assertEquals(responseBody.contains(FrameUtility.readConfigFileData("user_email")), true);
		Assert.assertEquals(responseBody.contains(FrameUtility.readConfigFileData("user_avtar")), true);
		Assert.assertEquals(responseBody.contains(FrameUtility.readConfigFileData("user_first_name")), true);
		Assert.assertEquals(responseBody.contains(FrameUtility.readConfigFileData("user_last_name")), true);
	}
	
	/* "verifyUserNotFoundRespose()" method is created to validate
	 * whether user which is not created yet
	 * canbe found or not.
	 */	
	public void verifyUserNotFoundRespose() {
		String responseBody = response.getBody().asString();
		System.out.println("responseBody is :" + responseBody);
		Assert.assertEquals(responseBody.contains(FrameUtility.readConfigFileData("user_email")), false);
		Assert.assertEquals(responseBody.contains(FrameUtility.readConfigFileData("user_first_name")), false);
		Assert.assertEquals(responseBody.contains(FrameUtility.readConfigFileData("user_last_name")), false);
	}	
	
	/* "verifyStatusCode()" method is created to 
	 * validate status code.
	 */
	public void verifyStatusCode(int expStatusCode) {
		int actStatusCode = response.getStatusCode();
		assertEquals(actStatusCode, expStatusCode);
	}

	/* "verifyStatusLineDetails()" method is created to 
	 * validate status line details.
	 * Argument: expStatusLine
	 */
	public void verifyStatusLineDetails(String expStatusLine) {
		String statusLine = response.getStatusLine(); // get the status Line
		assertEquals(statusLine, expStatusLine);
	}
	
	/* "verifyContentTypeDetails()" method is created to
	 * validate contentType details.
	 * Argument: expContentType
	 */	
	public void verifyContentTypeDetails(String expContentType) {
		String contentType = response.header("Content-Type");
		assertEquals(contentType, expContentType);		
	}	
	
	/* "createNewUserUsingPOSTRequest()" method canbe used to
	 * new user.
	 * Argument: endPointURI
	 */
	@SuppressWarnings("unchecked")
	public void createNewUserUsingPOSTRequest(String endPointURI) {		
		// JSONObject is a class that represents a simple JSON with input as 'Key-Value'
		// pair.
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", FrameUtility.readConfigFileData("new_user_name"));
		requestParams.put("job", FrameUtility.readConfigFileData("new_user_job"));

		response = 
			given()
				.header("Content-Type", "application/json")
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(requestParams.toJSONString())
			.when()
				.post(APIEndpointConstants.BASE_URI + endPointURI)
			.then()
				.extract()
				.response();
	}	

	/* "verifyNewlyCreatedUserRespose()" method canbe used to
	 * verify details of newly created user.
	 */
	public void verifyNewlyCreatedUserRespose() {
		String responseBody = response.getBody().asString();
		System.out.println("responseBody is :" + responseBody);
		Assert.assertEquals(responseBody.contains(FrameUtility.readConfigFileData("new_user_name")), true);
		Assert.assertEquals(responseBody.contains(FrameUtility.readConfigFileData("new_user_job")), true);
	}
	
	/* "updateUserDetailsUsingPUTRequest()" method canbe used to
	 * update user details.
	 * Argument: endPointURI, ID
	 */
	@SuppressWarnings("unchecked")
	public void updateUserDetailsUsingPUTRequest(String endPointURI, int ID) {
		// JSONObject is a class that represents a simple JSON with input as 'Key-Value'
		// pair.
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", FrameUtility.readConfigFileData("update_user_name"));
		requestParams.put("job", FrameUtility.readConfigFileData("update_user_job"));
	
		response = 		
			given()
				.pathParam("id", ID)
				.header("Content-Type", "application/json")
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON).body(requestParams.toJSONString())
			.when()
				.put(APIEndpointConstants.BASE_URI + endPointURI)
			.then()
				.statusCode(200)
				.log()
				.all()
				.extract()
				.response();
	}
	
	/* "verifyUserIsUpdatedAfterPUTRequest()" method canbe used to
	 * verify user details after update using PUT request.
	 */
	
	public void verifyUserIsUpdatedAfterPUTRequest() {
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		Assert.assertEquals(responseBody.contains(FrameUtility.readConfigFileData("update_user_name")), true);
		Assert.assertEquals(responseBody.contains(FrameUtility.readConfigFileData("update_user_job")), true);
	}
	
	/* "partialUpdateUserUsingPATCHRequest()" method canbe used to
	 * update user details partially using PATCH request.
	 * Argument: endPointURI, ID
	 */
	@SuppressWarnings("unchecked")
	public void partialUpdateUserUsingPATCHRequest(String endPointURI, int ID) {
		// JSONObject is a class that represents a simple JSON with input as 'Key-Value'
		// pair.
			JSONObject requestParams = new JSONObject();
			requestParams.put("name", FrameUtility.readConfigFileData("update_user_name"));
			requestParams.put("job", FrameUtility.readConfigFileData("partial_update_job"));
		
		response = 		
			given()
				.pathParam("id", ID)
				.header("Content-Type", "application/json")
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON).body(requestParams.toJSONString())
			.when()
				.patch(APIEndpointConstants.BASE_URI + endPointURI)
			.then()
				.statusCode(200)
				.log()
				.all()
				.extract()
				.response();		
	}
	
	/* "verifyUserIsUpdatedAfterPATCHRequest()" method canbe used to
	 * verify partially updated user details.
	 */
	public void verifyUserIsUpdatedAfterPATCHRequest() {
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		Assert.assertEquals(responseBody.contains(FrameUtility.readConfigFileData("update_user_name")), true);
		Assert.assertEquals(responseBody.contains(FrameUtility.readConfigFileData("partial_update_job")), true);
	}	
	
	/* "verifyUserIsUpdatedAfterPATCHRequest()" method canbe used to
	 * delete user record using DELETE request.
	 * Argument: endPointURI, ID
	 */
	public void deleteUserUsingDELETERequest(String endPointURI, int ID) {
		response = 
			given()
				.pathParam("id", ID)
				.contentType(ContentType.JSON)
			.when()
				.delete(APIEndpointConstants.BASE_URI + endPointURI)
			.then()
				.statusCode(204)
				.log()
				.all()
				.extract()
				.response();
	}
	
	/* "verifyUserIsDeletedAfterDELETERequest()" method canbe used to
	 * verify user record after deletion.
	 */
	public void verifyUserIsDeletedAfterDELETERequest() {
		String responseBody = response.getBody().asString();
		Assert.assertEquals(responseBody.contains(FrameUtility.readConfigFileData("update_user_name")), false);
		Assert.assertEquals(responseBody.contains(FrameUtility.readConfigFileData("update_user_job")), false);
	}	
}
