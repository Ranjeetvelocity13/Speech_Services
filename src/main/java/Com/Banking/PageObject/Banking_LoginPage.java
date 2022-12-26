package Com.Banking.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Banking.BaseClass.Banking_BaseClass;


public class Banking_LoginPage extends Banking_BaseClass {

//1.
	public Banking_LoginPage() {

		PageFactory.initElements(driver, this);
	}

//2. 
	@FindBy(name = "uid")
	public WebElement Username;

	@FindBy(xpath = "//input[@name=\"password\"]")
	public WebElement Password;

	@FindBy(name = "btnLogin")
	public WebElement LoginBtn;
	
	@FindBy(xpath = "//a[contains(text(),'Log out')]")
	public WebElement LogoutBtn;

//3.
	public void SetUsername(String Uname) {
		Username.sendKeys(Uname);
	}
	
	public void SetPassowrd(String Pwd) {
		Password.sendKeys(Pwd);
	}
	
	public void Clickbtn() {
		LoginBtn.click();
	}
	public void LogoutButton() {
		LogoutBtn.click();
	}
}
