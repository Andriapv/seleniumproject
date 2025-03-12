package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Pageutility;
import utilities.Waitutility;

public class Managecontactpage {
	public WebDriver driver;
	 Pageutility pg=new  Pageutility() ;
     Waitutility wait =new  Waitutility();
	public Managecontactpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/contact/edit_contact?edit=1']") WebElement updatecontactbutton;
    @FindBy(xpath="//input[@id='phone']") WebElement phonenumberfield;
	@FindBy(xpath="//input[@id='email']") WebElement emailidfield ;
	@FindBy(xpath="//textarea[@name='address']") WebElement addressfield;
	@FindBy(xpath="//textarea[@name='del_time']") WebElement  deliverytimefield;
	@FindBy(xpath="//input[@id='del_limit']") WebElement   deliverytimelimitfield;
	@FindBy(xpath="//button[@class='btn btn-block-sm btn-info']") WebElement  updatesubmitbutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement alertmessage;
	
	public Managecontactpage clickContactButton()
	{
		
			pg.javascriptclick(updatecontactbutton, driver);
			return this;
			
	}
	public Managecontactpage updatePhoneNumberInPhoneNumberField(String number)
	{
		phonenumberfield.clear();
		phonenumberfield.sendKeys(number);
		return this;
	}
	public Managecontactpage updateEmailIdInEmailId(String email)
	{
		emailidfield.clear();
		emailidfield.sendKeys(email);
		return this;
	}
	public Managecontactpage updateAddressInAddress(String email)
	{
		addressfield.clear();
		addressfield.sendKeys(email);
		return this;
	}
	public Managecontactpage updateDeliveryTimeInDeliveryTime(String deliverytime)
	{
		deliverytimefield.clear();
		deliverytimefield.sendKeys(deliverytime);
		return this;
	}
	public Managecontactpage updateDeliveryTimeLimitInDeliveryTimelimit(String deliverytimelimit)
	{
		deliverytimefield.clear();
		deliverytimefield.sendKeys(deliverytimelimit);
		return this;
	}
	public Managecontactpage submitButtonInUpdateContact()
	{
		pg.javascriptclick(updatesubmitbutton, driver);
		return this;		
	}
	public boolean isalertpresent()
	{
		return alertmessage.isDisplayed();
	}

	
	
}
