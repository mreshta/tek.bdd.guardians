package tek.bdd.guardians.pages;

import tek.bdd.guardians.base.BaseSetup;

public class POMFactory extends BaseSetup{
	
    private HomePage homePage;
    private LoginPage loginPage;
	private RetailAccountPage retailAccountPage;
	private RetailOrderPage retailOrderPage;
    public POMFactory() {
        this.homePage = new HomePage();
        this.loginPage = new LoginPage();
        this.retailAccountPage=new RetailAccountPage();
        this.retailOrderPage=new RetailOrderPage();
        
    }
    public HomePage homePage() {
        return this.homePage;
    }

    public LoginPage loginPage() {
        return this.loginPage;
    }
    
    public RetailAccountPage retailAccountPage() {
    	return this.retailAccountPage;
    }
    
    public RetailOrderPage retailOrderPage() {
    	return this.retailOrderPage;
    }
}
