package Com.Banking.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Banking.BaseClass.Banking_BaseClass;

public class Banking_AddNewCustomers extends Banking_BaseClass {

	// 1
	public Banking_AddNewCustomers() {

		PageFactory.initElements(driver, this);
	}

	// 2.

	@FindBy(xpath = "//a[text()='New Customer']")
	public WebElement NewCustomer;

	@FindBy(name = "name")
	public WebElement CustomerName;

	@FindBy(xpath = "//input[@type='radio']")
	public WebElement Gender;

	@FindBy(id = "dob")
	public WebElement DOB;

	@FindBy(name = "addr")
	public WebElement Address;

	@FindBy(name = "city")
	public WebElement City;

	@FindBy(name = "state")
	public WebElement State;

	@FindBy(name = "pinno")
	public WebElement Pin;

	@FindBy(name = "telephoneno")
	public WebElement TelephoneNo;

	@FindBy(name = "emailid")
	public WebElement Email;

	@FindBy(name = "sub")
	public WebElement Submit;

	@FindBy(name = "password")
	public WebElement Password;

	//3
	public void CreateNewCustomer() {
		NewCustomer.click();
	}

	public void SetCustomerName(String name) {
		CustomerName.sendKeys(name);
	}

	public void SetGender() {
		Gender.click();
	}

	public void SetDOB(String DD,String MM,String yy) {
		DOB.sendKeys(DD);
		DOB.sendKeys(MM);
		DOB.sendKeys(yy);
	}

	public void SetAddress(String address) {
		Address.sendKeys(address);
	}

	public void SetCity(String city) {
		City.sendKeys(city);
	}

	public void SetState(String state) {
		State.sendKeys(state);
	}

	public void SetPin(String pin) {
		Pin.sendKeys(pin);
	}

	public void SetTelephoneNo(String PhoneNo) {
		TelephoneNo.sendKeys(PhoneNo);
	}

	public void SetEmail(String emailid) {
		Email.sendKeys(emailid);
	}
	
	public void SetPassoword(String Pass) {
		Password.sendKeys(Pass);
	}

	public void Submit() {
		Submit.click();
	}
}