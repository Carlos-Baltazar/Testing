package com.unosquare;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.Reporter;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiPost {

	public void Post(String filePath, String URL, String typePost, int statusCode) throws IOException, ParseException {
		
			JSONParser json = new JSONParser();
			FileReader reader = new FileReader(filePath);
			Object obj = json.parse(reader);
			JSONObject jsonObject = (JSONObject) obj;
			
		    RestAssured.baseURI = "https://reqres.in/api"; 

			RequestSpecification httpRequest = RestAssured.given();
		    httpRequest.headers("Content-Type", "application/json");
		    httpRequest.body(jsonObject.toString());
		    Response response = httpRequest.post(URL);
		    Assert.assertEquals(statusCode, response.getStatusCode());
		    
		    Reporter.log("Type of post: " + typePost);
		    Reporter.log("Status for Post: " + response.getStatusCode());  
		    Reporter.log("Body for Post: " + response.asString());
	
	
	}

	public void Get(String URL, String typePost, int statusCode) {
		
		RestAssured.baseURI = "https://reqres.in/api/";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get(URL);
		
		Assert.assertEquals(statusCode,response.getStatusCode());
		Reporter.log("Type of post: " + typePost);
		Reporter.log("Status for Post: " + response.getStatusCode());  
		Reporter.log("Body for Post: " + response.asString());
		
	}
	public void Put(String filePath, String URL, String typePost, int statusCode) throws IOException, ParseException {
		
		JSONParser json = new JSONParser();
		FileReader reader = new FileReader(filePath);
		Object obj = json.parse(reader);
		JSONObject jsonObject = (JSONObject) obj;
		
	    RestAssured.baseURI = "https://reqres.in/api"; 

		RequestSpecification httpRequest = RestAssured.given();
	    httpRequest.headers("Content-Type", "application/json");
	    httpRequest.body(jsonObject.toString());
	    Response response = httpRequest.put(URL);
	    Assert.assertEquals(statusCode, response.getStatusCode());
	    
	    Reporter.log("Type of post: " + typePost);
	    Reporter.log("Status for Post: " + response.getStatusCode());  
	    Reporter.log("Body for Post: " + response.asString());
		
		
		
		
		
	}
}
