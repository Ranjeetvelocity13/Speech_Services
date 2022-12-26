package Com.Banking.TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mongodb.diagnostics.logging.Logger;

import Com.Banking.BaseClass.Banking_BaseClass;
import Com.Banking.PageObject.Banking_AddNewCustomers;
import Com.Banking.PageObject.Banking_LoginPage;
import net.bytebuddy.utility.RandomString;

public class TC_Add_NewCustomer extends Banking_BaseClass {

	
	@Test
	public void AddnewCutomaer() throws IOException {
		
		logger.info("Open URL");
		Banking_LoginPage BL = new Banking_LoginPage();
		logger.info("Enter Username");
		BL.SetUsername(username);
		logger.info("Enter Password");
		BL.SetPassowrd(Password);
		logger.info("Click on login button");
		BL.Clickbtn();
		
		Banking_AddNewCustomers BA =new Banking_AddNewCustomers();
		BA.CreateNewCustomer();
		logger.info("Click in add new customer tab");
		
		driver.navigate().refresh();
		BA.CreateNewCustomer();
		logger.info("Click in add new customer tab");
		
		BA.SetCustomerName("Rohit");
		logger.info("Enter customer name");
		
		BA.SetGender();
		logger.info("Select gender");

		BA.SetDOB("15", "06", "2000");
		logger.info("Select DOB");

		BA.SetAddress("Warje Pune");
		logger.info("Enter address");

		BA.SetCity("Pune");
		logger.info("Select City");

		BA.SetState("MH");
		logger.info("Select state");
		
		BA.SetPin("2345678");
		logger.info("Enter Pin number");

		BA.SetTelephoneNo("8390894567");
		logger.info("Enter mobile number");
		
		String Random=RandomString.make(5);
		
		String Email = Random+"@gmail.com";
		BA.SetEmail(Email);
		logger.info("Enter email address");

		BA.SetPassoword("QWERTYUI");
		logger.info("Enter Passowrd ");
		
		BA.Submit();
		
		
		
		boolean Test=driver.findElement(By.xpath("//p[contains(text(),'Customer Registered Successfully!!!')]")).isDisplayed();

		if(Test=true) {
			logger.info("User Created");
           AssertJUnit.assertTrue(true);
		}
		else {
			logger.info("User Creation failed");
               getScreenshotAs("AddNewCutomer");
			  AssertJUnit.assertTrue(false);
		}


	}
}
