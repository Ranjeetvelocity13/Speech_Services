package Com.Banking.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Banking.BaseClass.Banking_BaseClass;

public class TC_New_Account extends Banking_BaseClass {

	
	//1.
	public TC_New_Account() {
		
		PageFactory.initElements(driver, this);
	}
	
	//2.
	@FindBy(xpath = "//a[contains(text(),'New Account')]")
	public WebElement NewAccount;
	
	@FindBy(name = "cusid")
	public WebElement CustomerID;

	@FindBy(name = "inideposit")
	public WebElement Deposit;
	
	@FindBy(name = "button2")
	public WebElement Submitbutton;
	
	
	//
	public void Account() {		
		NewAccount.click();
	}
	
	public void AccountCustomerid(String Number) {
		CustomerID.sendKeys(Number);
	}
	public void AccountDeposit(String Value) {
		Deposit.sendKeys(Value);
	}
	public void Submit() {
		Submitbutton.click();
	}
}
