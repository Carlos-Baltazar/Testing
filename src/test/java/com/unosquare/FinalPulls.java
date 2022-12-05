package com.unosquare;

import org.testng.annotations.Test;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeMethod;

public class FinalPulls {
	
	  ApiPost apiPost = new ApiPost();

  @Test
  public void f() throws IOException, ParseException {
  
	  apiPost.Post(".\\Json\\successRegPost.json", "/register", " Post for successful register", 200);  
	  apiPost.Post(".\\Json\\failRegPost.json", "/register", "Post for unsucessful register", 400);
	  apiPost.Post(".\\Json\\successCreate.json", "/users", "Post for success create", 201);
	  apiPost.Post(".\\Json\\unsuccessLogin.json", "/login", "Post for unsucessful Login", 400);
	  
	  apiPost.Get("users?page=2", "Get list of users", 200);
	  apiPost.Get("users/2", "Get single user", 200);
	  apiPost.Get("users/23", "Get no single user found", 404);
	  apiPost.Get("unknown", "Get list", 200);
	  
	  apiPost.Put(".\\Json\\Update.json","users/2", "Update", 200);
  
  }
  
  
  
  
  
  
  @BeforeMethod
  public void beforeMethod() {
	  
	  apiPost = new ApiPost();

	  
  }

}
