package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

 
@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/appFeatures"},
		glue = {"stepDefinitions", "AppHooks"},
		plugin = {"pretty", 
				 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		tags="@SmokeTest"
				)
public class TestRunner {
}
