package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(features="features\\login.feature",
glue= {"stepDefinition"},
plugin= {"pretty","json:target/cucumber.json"}
		)

public class LoginTestRunner {

}
