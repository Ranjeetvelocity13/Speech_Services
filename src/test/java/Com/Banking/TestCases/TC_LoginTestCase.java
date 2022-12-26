package Com.Banking.TestCases;



import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import Com.Banking.BaseClass.Banking_BaseClass;
import Com.Banking.PageObject.Banking_LoginPage;


public class TC_LoginTestCase extends Banking_BaseClass{

	@Test
	public void LoginTest() {
	
		logger.info("Open URL");
		Banking_LoginPage BL = new Banking_LoginPage();
		logger.info("Enter Username");
		BL.SetUsername(username);
		logger.info("Enter Password");
		BL.SetPassowrd(Password);
		logger.info("Click on login button");
		BL.Clickbtn();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			AssertJUnit.assertTrue(true);
			logger.info("Test case passed");		
		}
		else {
			AssertJUnit.assertTrue(false);
			logger.info("Test case failed");
		}
	}
}
