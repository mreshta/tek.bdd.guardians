package tek.bdd.guardians.steps;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import tek.bdd.guardians.pages.POMFactory;
import tek.bdd.guardians.utilities.CommonUtility;

public class RetailOrderSteps extends CommonUtility {

	POMFactory pomFactory=new POMFactory();
	
	@Then("User change the category to {string}")
	public void userChangeTheCategoryTo(String Category) {
	selectByVisibleText(pomFactory.retailOrderPage().allDepartmentDropDown, Category);
	logger.info("Category was selected successfully from dropdown");
	
	}
	@Then("User search for an item {string}")
	public void userSearchForAnItem(String kasaOutDoorSmartPlug) {
	sendText(pomFactory.retailOrderPage().searchInputField, kasaOutDoorSmartPlug);
	logger.info("item name was entered successfully");
	
	}
	@Then("User click on Search icon")
	public void userClickOnSearchIcon() {
	click(pomFactory.retailOrderPage().searchBttn);
	logger.info("the search button was clicked successfully");
	}
	@Then("User click on item")
	public void userClickOnItem() {
	click(pomFactory.retailOrderPage().KasaOutDoorSmartPlug);
	logger.info("the item was clicked successfully");
	}
	@Then("User select quantity {string}")
	public void userSelectQuantity(String qty) {
	selectByVisibleText(pomFactory.retailOrderPage().qtyDropDown, qty);  
	}
	@Then("User click add to Cart button")
	public void userClickAddToCartButton() {
	click(pomFactory.retailOrderPage().addToCardBttn);
	logger.info("the cart button was clicked successfully");
	}
	@Then("the cart icon quantity should change to {string}")
	public void theCartIconQuantityShouldChangeTo(String itemQty) {
		Assert.assertEquals(itemQty, pomFactory.retailOrderPage().cartQty.getText());
		logger.info("the item quntity was verified successfully");
	}
	
//	add order and checkout
	
	
	@Then("User change the category to {string} Apex Legends")
	public void userChangeTheCategoryToApexLegends(String Electorincs) {
	selectByVisibleText(pomFactory.retailOrderPage().allDepartmentDropDown, Electorincs);
	logger.info("the electronics field was selected successfully");
	}
	@Then("User search for an item {string} Apex Legends")
	public void userSearchForAnItemApexLegends(String apexLegends) {
	sendText(pomFactory.retailOrderPage().searchInputField, apexLegends);
	logger.info("the apex legends was entred successfully");
	}
	@Then("User click on item Apex Legends")
	public void userClickOnItemApexLegends() {
	click(pomFactory.retailOrderPage().apexLegendsItems);
	logger.info("the apex legend was clicked successfully");
	}
	
	@Then("User select quantity {string} for Apex Legends")
	public void userSelectQuantityForApexLegends(String apexLegendQty) {
	selectByVisibleText(pomFactory.retailOrderPage().qtyDropDown,apexLegendQty);
	logger.info("the apex legend quantity was selected successfully");
	}
	
	@Then("the cart icon quantity should change to {string} Apex Legends")
	public void theCartIconQuantityShouldChangeToApexLegends(String itemsinTheCart) {
		Assert.assertEquals(itemsinTheCart, pomFactory.retailOrderPage().cartQty.getText());
		logger.info("the item quntity was verified successfully");   
	}
	@Then("User click on Cart option")
	public void userClickOnCartOption() {
	click(pomFactory.retailOrderPage().cartBttn);
	logger.info("the cart button was clicked successfully");
	}
	@Then("User click on Proceed to Checkout button")
	public void userClickOnProceedToCheckoutButton() {
	click(pomFactory.retailOrderPage().proceedToCheckOutBttn);
	logger.info("the proceed to checkout button was clicked successfully");
	}
	@Then("User click on Place Your Order")
	public void userClickOnPlaceYourOrder() {
	click(pomFactory.retailOrderPage().placeOrderBttn);
	logger.info("the click on your order button was clicked successfully");
		
	}
}
