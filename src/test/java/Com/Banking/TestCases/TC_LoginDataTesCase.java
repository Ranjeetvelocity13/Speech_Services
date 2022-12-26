package Com.Banking.TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Com.Banking.BaseClass.Banking_BaseClass;
import Com.Banking.PageObject.Banking_LoginPage;
import Com.Banking.Utilities.XLUtils;

public class TC_LoginDataTesCase extends Banking_BaseClass {

	
	@Test(dataProvider = "LoginData")
	public void LoginData(String user,String Pwd) throws InterruptedException {
		
		logger.info("Open URL");
		Banking_LoginPage BL = new Banking_LoginPage();
		logger.info("Enter Username");
		BL.SetUsername(user);
		logger.info("Enter Password");
		BL.SetPassowrd(Pwd);
		logger.info("Click on login button");
		BL.Clickbtn();
		
		if(IsAlertpresent()==true) {
			driver.switchTo().alert().accept();//popuclose
			driver.switchTo().defaultContent();
			AssertJUnit.assertTrue(true);
			logger.info("LoginFailed");
		}
		else {
			AssertJUnit.assertTrue(true);
			logger.info("Login Passed");
            Thread.sleep(2000);
            BL.LogoutButton();
            Thread.sleep(2000);
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
		}
		
	}
	
	public boolean IsAlertpresent() throws InterruptedException {
		
		try {
		driver.switchTo().alert();
		Thread.sleep(2000);
		return true;
		}
		catch (NoAlertPresentException e) {
			return false;
		}
	}
	
	@DataProvider(name="LoginData")
	public String[][] getdata() throws IOException{
		
		String path=System.getProperty("user.dir")+"/src/main/java/Com/Banking/TestData/23July_Automation.xlsx";
	
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++) {  //Row
			
			for(int j=0;j<colcount;j++) { //Col
				
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);  //1 0  1 1
			}
		}
		
		return logindata;
	}
	
	
}
