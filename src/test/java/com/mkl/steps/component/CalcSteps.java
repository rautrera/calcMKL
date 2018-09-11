package com.mkl.steps.component;

import org.testng.Assert;

import com.makinglab.ws.rest.VO.Calculadora;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CalcSteps {
	
	private Calculadora calc = new Calculadora();
	
	@Given("los numeros {int} y {int}")
	public void los_numeros_y(int int1, int int2) {
	    // Write code here that turns the phrase above into concrete actions
	    calc.setNro1(int1);
	    calc.setNro2(int2);
	}

	@When("la operacion seleccionada es {string}")
	public void la_operacion_seleccionada_es(String operacion) {
	    // Write code here that turns the phrase above into concrete actions
	    calc.setOperacion(operacion);
	}

	@Then("el resultado debe ser {int}")
	public void el_resultado_debe_ser(int resultadoEsperado) {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(resultadoEsperado, calc.getResultado());
	}
}
