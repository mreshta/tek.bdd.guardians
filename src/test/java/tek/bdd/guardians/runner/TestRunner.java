package tek.bdd.guardians.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

import org.junit.runner.RunWith;
//we use the @RunWith from JUnit and then use the CucumberOptions to setup the TestRunner class 
// Make sure to type your code outside the class

@RunWith(Cucumber.class)
@CucumberOptions(
		
		tags="@login",
		features= ("classpath:features"),
		glue ="tek.bdd.guardians",
		dryRun= false,
		plugin= {
				"pretty",
				"html:target/htmlReports/cucumber-pretty.html",
				"json:target/jsonReports/cucumber.json"
		},
		snippets=CAMELCASE,
		monochrome=true
		
		
		)

public class TestRunner {

}
