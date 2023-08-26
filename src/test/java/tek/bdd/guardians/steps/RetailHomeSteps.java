package tek.bdd.guardians.steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.bdd.guardians.utilities.CommonUtility;
import tek.bdd.guardians.pages.POMFactory;

public class RetailHomeSteps extends CommonUtility {

//	we will create object of POMFactory class to access the page objects in page object classes 
//	using the get method we create in the POMFactory class
	
	POMFactory pomFactory= new POMFactory();
	
	@When("User click on All section")
	public void userClickOnAllSection() {
	 click(pomFactory.homePage().allOptions);
	 logger.info("All options dropdown was clicked!");
		
	}
	@Then("below options are present in Shop by Department sidebar")
	public void belowOptionsArePresentInShopByDepartmentSidebar(DataTable dataTable) {
	   List<List<String>>shopByDepartment=dataTable.asLists(String.class);
	   for(int i=0; i<shopByDepartment.get(0).size(); i++) {
		   Assert.assertTrue(isElementDisplayed
		   (getDriver().findElement(
		   By.xpath("//div[@class='sidebar__content']//span[text()='"+shopByDepartment.get(0).get(i)+"']"))));
		   logger.info("Options"+shopByDepartment.get(0).get(i)+"is displayed");
	   }
	}
}
