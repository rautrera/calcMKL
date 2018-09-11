package com.mkl.steps.services;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.util.JsonParserSequence;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;


public class CalcStepsServices {
	
	
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;
	protected JSONObject requestParams = new JSONObject();
	
	@Given("el siguiente {string} endpoint")
	public void el_siguiente_endpoint(String string) {
	    // Write code here that turns the phrase above into concrete actions
		RestAssured.baseURI = string;
		request = RestAssured.given();
	}

	@Given("los operadores {int} y {int}")
	public void los_operadores_y(Integer int1, Integer int2) {
	    // Write code here that turns the phrase above into concrete actions
		try {
			requestParams.put("nro1", int1);
			requestParams.put("nro2", int2);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			throw new PendingException();
		}
	}

	@When("la operacion seleccionada es {string}")
	public void la_operacion_seleccionada_es(String string) {
	    // Write code here that turns the phrase above into concrete actions
		try {
			requestParams.put("operacion", string);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			throw new PendingException();
		}
	}

	@Then("se espera el {int} y el resultado {int}")
	public void se_espera_el_y_el_resultado(Integer int1, Integer int2) {
	    // Write code here that turns the phrase above into concrete actions
		request.body(requestParams.toString());
		Response response = request.get("calcular");
		 
		int statusCode = response.getStatusCode();
		System.out.println("The status code recieved: " + statusCode);
	 
		System.out.println("Response body: " + response.body().asString());
		JsonParserSequence parser;
		//JSONObject json = (JSONObject) parser.pa(stringToParse);

		
	}
}
