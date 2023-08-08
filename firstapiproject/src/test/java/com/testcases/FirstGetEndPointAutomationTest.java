package com.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class FirstGetEndPointAutomationTest {


	@Test
	public void testCase() {

		RequestSpecification requestSpecification = RestAssured.given();

		requestSpecification.contentType("application/json");

		Response response = requestSpecification.get("https://restful-booker.herokuapp.com/booking/2");
		
		System.out.println(response.statusCode());
		System.out.println(response.asPrettyString());
		
		//Assert.assertEquals(response.statusCode(), 200);
		System.out.println(response.jsonPath().getString("bookingdates.checkout"));
		System.out.println(response.jsonPath().getString("lastname"));
		System.out.println(response.jsonPath().getString("totalprice"));
		
		
		Assert.assertEquals(response.jsonPath().getString("bookingdates.checkin"), "2017-06-03");
		Assert.assertEquals(response.jsonPath().getString("firstname"), "Sally");
		Assert.assertEquals(response.jsonPath().getString("lastname"), "Wilson");
		Assert.assertEquals(response.jsonPath().getString("totalprice"), "582");
		
		
		
	}

}
