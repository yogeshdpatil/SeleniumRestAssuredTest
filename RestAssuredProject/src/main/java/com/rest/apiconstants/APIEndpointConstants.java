package com.rest.apiconstants;

public class APIEndpointConstants {
	public static final String CONFIG_FILE_PATH = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\DataConfig.properties";
	public static final String LOG4J_FILE_PATH = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\log4j.properties";
	
	public static final String BASE_URI = "https://reqres.in";

	public static final String GET_ALL_USERS = "/api/users?page=2";
	public static final String GET_SINGLE_USER = "/api/users/{id}";
	public static final String DELETE_USER = "/api/users/{id}";
	public static final String CREATE_USER = "/api/users";
	public static final String UPDATE_USER = "/api/users/{id}";
}
