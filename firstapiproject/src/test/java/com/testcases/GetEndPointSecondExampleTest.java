package com.testcases;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetEndPointSecondExampleTest {




	@Test
	public void testCase() {

		RequestSpecification requestSpecification =	RestAssured.given();
		
		requestSpecification.contentType("application/json");
		
		Response response =	requestSpecification.get("https://api.instantwebtools.net/v1/airlines/1");
		
		System.out.println(response.getStatusCode());
		System.out.println(response.asPrettyString());
		
		System.out.println(response.jsonPath().getString("name"));
	}
}
