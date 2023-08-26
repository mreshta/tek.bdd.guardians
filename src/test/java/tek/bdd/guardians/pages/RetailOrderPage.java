package tek.bdd.guardians.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.bdd.guardians.base.BaseSetup;

public class RetailOrderPage extends BaseSetup{

	public RetailOrderPage() {
		PageFactory.initElements(getDriver(), this);
		
	}
	
	@FindBy(id="search")
	public WebElement allDepartmentDropDown;
		
	@FindBy(id="searchInput")
	public WebElement searchInputField;
	
	@FindBy(id="searchBtn")
	public WebElement searchBttn;
		
	@FindBy(xpath="//img[@alt='Kasa Outdoor Smart Plug']")
	public WebElement KasaOutDoorSmartPlug;
	
	
	@FindBy(xpath="//select[starts-with(@class,'product')]")
	public WebElement qtyDropDown;
	
	@FindBy(id="addToCartBtn")
	public WebElement addToCardBttn;
	
	@FindBy(xpath="//span[@id='cartQuantity']")
	public WebElement cartQty;
	
	
//	add and checkout scenario
	
	@FindBy(id="cartBtn")
	public WebElement cartBttn;

	@FindBy(id="proceedBtn")
	public WebElement proceedToCheckOutBttn;
	
	@FindBy(id="placeOrderBtn")
	public WebElement placeOrderBttn;
	
	@FindBy(xpath="//p[text()='Order Placed, Thanks']")
	public WebElement orderPlacedSuccessMssg;
	
	@FindBy(xpath="//img[starts-with(@alt,'Apex Legends')]")
	public WebElement apexLegendsItems;
	
	
	
	
}
