package tek.bdd.guardians.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.bdd.guardians.pages.POMFactory;
import tek.bdd.guardians.utilities.CommonUtility;
import tek.bdd.guardians.utilities.DataGenerator;

public class RetailAccountSteps extends CommonUtility {

	POMFactory pomFactory = new POMFactory();

	@When("User click on Account option")
	public void userClickOnAccountOption() {
		click(pomFactory.retailAccountPage().accountLink);
		logger.info("account link was clicked");
	}

	@When("User update Name {string} and Phone {string}")
	public void userUpdateNameAndPhone(String name, String phoneNumber) {
		clearTextUsingSendKeys(pomFactory.retailAccountPage().nameField);
		sendText(pomFactory.retailAccountPage().nameField, name);
		logger.info("name was entered");
		clearTextUsingSendKeys(pomFactory.retailAccountPage().phoneField);
		sendText(pomFactory.retailAccountPage().phoneField, phoneNumber);
		logger.info("phone Field was filled");

	}

	@When("User click on Update button")
	public void userClickOnUpdateButton() {
		click(pomFactory.retailAccountPage().updateBtn);
		logger.info("update button was clicked");
	}

	@Then("user profile information should be updated")
	public void userProfileInformationShouldBeUpdated() {
		waitTillPresence(pomFactory.retailAccountPage().updateMssg);
		String expectedMsg = "Personal Information Updated Successfully";
		String actualMsg = pomFactory.retailAccountPage().updateMssg.getText();
		Assert.assertEquals(expectedMsg, actualMsg);
		logger.info("the account information was updated");
	}

// add payment method

	@When("User click on Add a payment method link")
	public void userClickOnAddAPaymentMethodLink() {
		click(pomFactory.retailAccountPage().addPaymentBttn);
		logger.info("the payment method button was clicked");
	}

	@When("User fill Debit or credit card information")
	public void userFillDebitOrCreditCardInformation(DataTable dataTable) {
		List<Map<String, String>> paymentInfo = dataTable.asMaps(String.class, String.class);
		sendText(pomFactory.retailAccountPage().cardNumberInput, paymentInfo.get(0).get("cardNumber"));
		sendText(pomFactory.retailAccountPage().nameOnCardInput, paymentInfo.get(0).get("nameOnCard"));
		selectByVisibleText(pomFactory.retailAccountPage().expirationMonth, paymentInfo.get(0).get("expirationMonth"));
		selectByVisibleText(pomFactory.retailAccountPage().expirationYearInput,
				paymentInfo.get(0).get("expirationYear"));
		sendText(pomFactory.retailAccountPage().securityCodeInput, paymentInfo.get(0).get("securityCode"));
		logger.info("paymentInformation was entred successfully");
	}

	@When("User click on Add your card button")
	public void userClickOnAddYourCardButton() {
		click(pomFactory.retailAccountPage().paymentSubmitBttn);
		logger.info("payment button was clicked");
	}

	@Then("a message should be displayed {string}")
	public void aMessageShouldBeDisplayed(String expectedMssg) {
		if (expectedMssg.contains("Payment Method added sucessfully")) {
			waitTillPresence(pomFactory.retailAccountPage().paymentMethodSuccessMSG);
			Assert.assertEquals(expectedMssg, pomFactory.retailAccountPage().paymentMethodSuccessMSG.getText());
			logger.info("Expected Msg: " + expectedMssg);
		} 
	else if (expectedMssg.contains("Address Added")) {
			waitTillPresence(pomFactory.retailAccountPage().addressSuccessMSG);
			Assert.assertEquals(expectedMssg, pomFactory.retailAccountPage().addressSuccessMSG.getText());
			logger.info("Expected Message: " + expectedMssg);
} 	else if (expectedMssg.contains("Order Placed")) {
	
		waitTillPresence(pomFactory.retailOrderPage().orderPlacedSuccessMssg);
		Assert.assertEquals(expectedMssg, pomFactory.retailOrderPage().orderPlacedSuccessMssg.getText());
}

}   @When("User click on Add address option")
	public void userClickOnAddAddressOption() {
		click(pomFactory.retailAccountPage().addAddresstMethod);
		logger.info("the address button was clicked");

	}

	@When("User fill new address form with below information")
	public void userFillNewAddressFormWithBelowInformation(DataTable dataTable) {
		List<Map<String, String>> addressInfo = dataTable.asMaps(String.class, String.class);
		selectByVisibleText(pomFactory.retailAccountPage().countryDropDown,
				DataGenerator.addressGenerator(addressInfo.get(0).get("country")));

		sendText(pomFactory.retailAccountPage().fullNameInput,
				DataGenerator.addressGenerator(addressInfo.get(0).get("fullName")));
		sendText(pomFactory.retailAccountPage().phoneNumberInput,
				DataGenerator.addressGenerator(addressInfo.get(0).get("phoneNumber")));
		sendText(pomFactory.retailAccountPage().streetInput,
				DataGenerator.addressGenerator(addressInfo.get(0).get("streetAddress")));
		sendText(pomFactory.retailAccountPage().appartmentInput,
				DataGenerator.addressGenerator(addressInfo.get(0).get("apt")));
		sendText(pomFactory.retailAccountPage().cityInput,
				DataGenerator.addressGenerator(addressInfo.get(0).get("city")));
		sendText(pomFactory.retailAccountPage().stateInput,
				DataGenerator.addressGenerator(addressInfo.get(0).get("state")));
		sendText(pomFactory.retailAccountPage().zipCodeInput,
				DataGenerator.addressGenerator(addressInfo.get(0).get("zipCode")));

		logger.info("Address updated successfully");

	}

	@When("User click Add Your Address button")
	public void userClickAddYourAddressButton() {
		click(pomFactory.retailAccountPage().addressBttn);
		logger.info("the address button was clicked");
	}

}
