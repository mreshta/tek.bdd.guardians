package tek.bdd.guardians.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.bdd.guardians.base.BaseSetup;

public class HomePage extends BaseSetup {

//	we will create on constructor and by using the initElements method from pagaFactory class we will
//	initialize out page objects in this class
	public HomePage() {
		
		PageFactory.initElements(getDriver(), this);
		
	}
//	we will use the @Factory annotation from the selenium to find the elements instead of findElement() of findElements() 
//	methods
	
	@FindBy(linkText= "TEKSCHOOL")
	public WebElement tekSchoolLogo;
	
	@FindBy(id="hamburgerBtn")
	public WebElement allOptions;
	
	@FindBy(xpath="//div[@class='sidebar__content']//span")
	public List<WebElement> sideBarOptions;
	
}

