package com.mkl.steps.ui;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class CalcStepsUI {
	
	  private WebDriver driver;	
	
	@Given("entro a la url {string}")
	public void entro_a_la_url(String string) {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.gecko.driver", "src/test/java/drivers/geckodriver.exe");
		driver = new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.get("http://localhost:8080/calcMKL/index.jsp?");
	}

	@Given("ingreso {string} y {string} en los operandos")
	public void ingreso_y_en_los_operandos(String nro1, String nro2) {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("nro1")).click();
	    driver.findElement(By.id("nro1")).clear();
	    driver.findElement(By.id("nro1")).sendKeys(nro1);
	    driver.findElement(By.id("nro2")).click();
	    driver.findElement(By.id("nro2")).clear();
	    driver.findElement(By.id("nro2")).sendKeys(nro2);
	}

	@Given("selecciono el siguiente {string}")
	public void selecciono_el_siguiente(String operacion) {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("operacion")).click();
		new Select(driver.findElement(By.id("operacion"))).selectByVisibleText(operacion);
		driver.findElement(By.id("operacion")).click();
	}

	@When("presiono Calcular")
	public void presiono_Calcular() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("calcButton")).click();
	}

	@Then("el resultado sera {string}")
	public void el_resultado_sera(String resultado) {
	    // Write code here that turns the phrase above into concrete actions
		      assertEquals(resultado, driver.findElement(By.id("resultado")).getAttribute("value"));
	}

	@Then("el mensaje de error sera {string}.")
	public void el_mensaje_de_error_sera(String msjError) {
	    // Write code here that turns the phrase above into concrete actions
		assertTrue(driver.findElement(By.id("msjError")).isDisplayed());
		assertEquals(msjError, driver.findElement(By.id("msjError")).getText());
	}

	@Then("se marcara el {string} con error en rojo")
	public void se_marcara_el_con_error_en_rojo(String camposErroneos) {
	    // Write code here that turns the phrase above into concrete actions
		List<String> camposError = Arrays.asList(camposErroneos.split(";"));
		for(String campoError: camposError) {
			assertEquals("form-control border-danger", driver.findElement(By.id(campoError)).getAttribute("class"));
	    }
	}
}
