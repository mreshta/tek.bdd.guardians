package tek.bdd.guardians.steps;

import tek.bdd.guardians.utilities.CommonUtility;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.bdd.guardians.pages.POMFactory;

public class LoginSteps extends CommonUtility {

	POMFactory pomfactory = new POMFactory();

	@Given("User is on retail website homepage")
	public void userIsOnRetailWebsiteHomepage() {
		Assert.assertTrue(pomfactory.homePage().tekSchoolLogo.isDisplayed());
	}

	@When("User click on the login link")
	public void userClickOnTheLoginLink() {
	   click(pomfactory.loginPage().signInLink);
	   logger.info("Login Link Was clicked successfully");
	}
	@When("User enter email {string} and password {string}")
    public void userEnterEmailAndPassword(String email, String password) {
        sendText(pomfactory.loginPage().emailField, email);
		sendText(pomfactory.loginPage().passwordField, password);
	    logger.info("Email and Password were entered successfully");
	    
	}
    @When("User click on login button")
    public void userClickOnLoginButton() {
        click(pomfactory.loginPage().loginBttn);
        logger.info("Login button was clicked successfully");
    }
    @Then("Verify user is logged in")
    public void verifyUserIsLoggedIn() {
        Assert.assertTrue(pomfactory.loginPage().logoutBttn.isDisplayed());
        logger.info("User is logged in successfully");}
        
//    //register
    @When("User click on create new account link")
    public void userClickOnCreateNewAccountLink() {
        click(pomfactory.loginPage().newAccountBttn);
        logger.info("Create new account bttn clicked successfully");
    }
    @When("User enter {string} and {string} and {string} and {string}")
    public void userEnterAndAndAnd(String name, String email, String password, String confPassword) {
        sendText(pomfactory.loginPage().nameInputField, name);
        sendText(pomfactory.loginPage().emailInputField, email);
        sendText(pomfactory.loginPage().passwordInputField, password);
        sendText(pomfactory.loginPage().confirmPassInputField, confPassword);
        logger.info("User information was entered successfully");
    }
    @When("User click on singup button")
    public void userClickOnSingupButton() {
        click(pomfactory.loginPage().signupBttn);
        logger.info("Signup button was clicked sucessfully");
    }
    @Then("Verify user account is created")
    public void verifyUserAccountIsCreated() {
        Assert.assertTrue(pomfactory.loginPage().yourProfileText.isDisplayed());
        logger.info("User account is created successfully");

        

}}
