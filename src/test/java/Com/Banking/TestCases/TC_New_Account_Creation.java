package Com.Banking.TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Com.Banking.BaseClass.Banking_BaseClass;
import Com.Banking.PageObject.Banking_LoginPage;
import Com.Banking.PageObject.TC_New_Account;

public class TC_New_Account_Creation extends Banking_BaseClass{

	@Test
	public void AddNewAccount() throws IOException {
	
	Banking_LoginPage BL = new Banking_LoginPage();
	logger.info("Open URL");

	BL.SetUsername(username);
	logger.info("Enter Username");

	BL.SetPassowrd(Password);
	logger.info("Enter Password");

	BL.Clickbtn();
	logger.info("Click on login button");

	TC_New_Account TNA = new TC_New_Account();
	
	TNA.Account();
	logger.info("Click on New Account tab");

	driver.navigate().refresh();
	
	TNA.Account();
	logger.info("Click on New Account tab");
	
	TNA.AccountCustomerid("96016");
	logger.info("Enter Customer ID");

	TNA.AccountDeposit("3000");
	logger.info("Enter deposit value");

	TNA.Submit();
	logger.info("Click on the submit button");

	boolean Test=driver.findElement(By.xpath("//p[@class=\"heading3\"]")).isDisplayed();
	
	if(Test==true) {
		logger.info("Account Created");
        AssertJUnit.assertTrue(true);       
	}
	else {
		getScreenshotAs("New_Account");
		logger.info("Account creation failed");
        AssertJUnit.assertTrue(false);       

		
	}
	}
}
