package com.mkl.test.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@CucumberOptions(
features = {"src/test/java/com/mkl/features/services"},
glue = {"src/test/java/","com.mkl.steps.services"},
monochrome = true
)
@RunWith(Cucumber.class)
public class RunnerServices {

}
