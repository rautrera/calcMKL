package com.mkl.test.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@CucumberOptions(
features = {"src/test/java/com/mkl/features/ui"},
glue = {"src/test/java/","com.mkl.steps.ui"},
plugin = {"pretty"},
monochrome = true
)
@RunWith(Cucumber.class)
public class RunnerUI {
	
	

}
