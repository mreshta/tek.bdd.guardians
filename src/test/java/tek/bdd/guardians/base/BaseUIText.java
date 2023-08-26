package tek.bdd.guardians.base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import tek.bdd.guardians.utilities.CommonUtility;

public class BaseUIText extends CommonUtility {

	/*
	 * @Before
	 * is a Cucumber hook and we can write the code implementation in this method and the purpose of this method 
	 * is to execute this block of code before each Scenario and Scenario Outline
	 * 
	 * for now we will just call the method setupBrowser()
	 * 
	 * @After
	 * is a Cucumber hook and we can write the code implementation in this method and the purpose of this method 
	 * is to execute this block of code after each Scenario and Scenario Outline
	 * 
	 * for now we will check and see if Scenario or Scenario outline fials, so that it takes a screenshot of failed test
	 * for that test case and ad it to out test report and then close the browser
	 * 
	 *  or if scenario and scenario outlines passes, so that it just closes the browser
	 */
	
	
	@Before
	
	public void setupTests() {
		
			super.setupBrowser();
	}
	
	@After
	public void closeTests(Scenario scenario) {
		if(scenario.isFailed()) {
			byte[]screenshot=takeScreenShotAsBytes();
			scenario.attach(screenshot, "image/png", scenario.getName()+" scenario failed");
			
		}
		super.quitBrowser();
	}
}
