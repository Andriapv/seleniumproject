package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtility;

public class Loginpage {
	public WebDriver driver;

	public Loginpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='username']")
	WebElement usernamefield;
	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordfield;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement signinbutton;
	@FindBy(xpath = "//span[text()='7rmart supermarket']")
	WebElement headertag;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement errormessage;

	public void enterusernameinusernamefield(String username) {
		usernamefield.sendKeys(username);
	}

	public void enterpasswordinpasswordfield(String password) {
		passwordfield.sendKeys(password);
	}

	public Homepage clicksigninbutton() {
		signinbutton.click();
		return new Homepage(driver);
	}

	public boolean ishomepageloaded() {
		return headertag.isDisplayed();
	}

	public boolean isalertdisplayed() {
		return errormessage.isDisplayed();

	}

	public Homepage loginUsingExceldata() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "loginpage");
		String password = ExcelUtility.readStringData(1, 1, "loginpage");
		usernamefield.sendKeys(username);
		passwordfield.sendKeys(password);
		signinbutton.click();
		return new Homepage(driver);

	}

	public Homepage loginUsingInvaliddatafromExceldata() throws IOException {
		String username = ExcelUtility.readStringData(2, 1, "loginpage");
		String password = ExcelUtility.readStringData(1, 2, "loginpage");
		usernamefield.sendKeys(username);
		passwordfield.sendKeys(password);
		signinbutton.click();
		return new Homepage(driver);

	}

}
