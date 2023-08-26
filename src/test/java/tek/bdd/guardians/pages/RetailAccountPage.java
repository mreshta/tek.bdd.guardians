package tek.bdd.guardians.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.bdd.guardians.base.BaseSetup;

public class RetailAccountPage extends BaseSetup {

	
	public RetailAccountPage() {
		PageFactory.initElements(getDriver(), this);
	}
	@FindBy(linkText="Account")
	public WebElement accountLink;
	
	@FindBy(id="nameInput")
	public WebElement nameField;
	
	@FindBy(id="personalPhoneInput")
	public WebElement phoneField;
	
	@FindBy(id="personalUpdateBtn")
	public WebElement updateBtn;
	
	@FindBy(xpath="//div[text()='Personal Information Updated Successfully']")
	public WebElement updateMssg;
	
	
//	add payment method
	
	@FindBy(xpath="//p[text()='Add a payment method']")
	public WebElement addPaymentBttn;
	
	@FindBy(id="cardNumberInput")
	public WebElement cardNumberInput;
	
	@FindBy(id="nameOnCardInput")
	public WebElement nameOnCardInput;
	
	@FindBy(id="expirationMonthInput")
	public WebElement expirationMonth;
	
	@FindBy(id="expirationYearInput")
	public WebElement expirationYearInput;
	
	@FindBy(id="securityCodeInput")
	public WebElement securityCodeInput;
	
	@FindBy(id="paymentSubmitBtn")
	public WebElement paymentSubmitBttn;
	
	@FindBy(xpath="//div[text()='Payment Method added sucessfully']")
	public WebElement paymentMethodSuccessMSG;
	
	
//	Add An Address button
	
	@FindBy(xpath="//p[text()='Add Address']")
	public WebElement addAddresstMethod;
	
	@FindBy(id="countryDropdown")
	public WebElement countryDropDown;
	
	@FindBy(id="fullNameInput")
	public WebElement fullNameInput;
	
	@FindBy(id="phoneNumberInput")
	public WebElement phoneNumberInput;
	
	@FindBy(id="streetInput")
	public WebElement streetInput;
	
	@FindBy(id="apartmentInput")
	public WebElement appartmentInput;
	
	@FindBy(id="cityInput")
	public WebElement cityInput;
	
	@FindBy(name="state")
	public WebElement stateInput;
	
	@FindBy(id="zipCodeInput")
	public WebElement zipCodeInput;
	
	@FindBy(id="addressBtn")
	public WebElement addressBttn;
	
	@FindBy(xpath="//div[text()='Address Added Successfully']")
	public WebElement addressSuccessMSG;
	
	
}
