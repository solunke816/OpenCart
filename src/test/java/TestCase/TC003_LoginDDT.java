package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import Utilities.DataProviders;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC003_LoginDDT extends BaseClass{

	@Test(dataProvider ="LoginData",dataProviderClass=DataProviders.class,groups="Datadriven")
	public void verify_loginDDT(String email ,String Pass,String exp) throws InterruptedException {
		
		logger.info("***** stating TC_003_LoginDDT ******");
		try {
		//HomePage
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//Login
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(exp);
		lp.clickLogin();
		
		//MyAccount
		MyAccountPage myc=new MyAccountPage(driver);
		boolean targetPage=myc.isMyAccountPageExists();
		
		if(exp.equalsIgnoreCase("Valid")) 
		{
			if(targetPage==true) {
				myc.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("invalid")) 
		{
			if(targetPage==false) {
				myc.clickLogout();
				Assert.assertFalse(false);
			}
			else {
				Assert.assertFalse(true);
			}
		}
		
		}catch(Exception e) 
		
		{
		Assert.fail();
		}
		logger.info("***** Finished TC_003_LoginDDT ******");
	}
	
}
