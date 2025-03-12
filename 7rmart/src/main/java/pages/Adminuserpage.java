package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import utilities.Pageutility;
import utilities.Waitutility;

public class Adminuserpage {
	public WebDriver driver;
	 Pageutility pg=new  Pageutility() ;
     Waitutility wait =new  Waitutility();
	public Adminuserpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@onclick='click_button(1)']") WebElement newbutton;
	@FindBy(xpath="//input[@id='username']") WebElement usernamefield;
	@FindBy(xpath="//input[@id='password']") WebElement passwordfield;
	@FindBy(xpath="//select[@id='user_type']") WebElement usertype;
	@FindBy(xpath="//button[@name='Create']") WebElement submitbutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement alertmessage;
	@FindBy(xpath="//a[@onclick='click_button(2)']") WebElement searchbutton;
	@FindBy(xpath="//input[@id='un']") WebElement usernameinsearch;
	@FindBy(xpath="//select[@id='ut']") WebElement usertypeinsearch;
	@FindBy(xpath="//button[@name='Search']") WebElement submitbuttonsearch;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tr//td[1]") WebElement tablesearch;
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-primary btncss']") WebElement updatebutton;
	@FindBy(xpath="//input[@id='username']") WebElement usernameupdate;
	@FindBy(xpath="//button[@name='Update']") WebElement submitbuttoninupdate;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement alertmessageinupdate;
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-danger btncss']") WebElement deletebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement alertmessageindelete;
	
	
	
	
	public Adminuserpage clickNewButton()
	{
		pg.javascriptclick(newbutton, driver);
		return this;
	}
	
	public Adminuserpage enterUserNameInUserNameField(String username)
	{
		usernamefield.sendKeys(username+pg.generateCurrentDateAndTime());
		return this;
	}
	public Adminuserpage enterPasswordInPasswordField(String password)
	{
		passwordfield.sendKeys(password);
		return this;
	}
	public Adminuserpage selectUserTypeInUserTypeField()
	{
		pg.selectDropdownWithVisibleText( usertype,"Admin");
		return this;
		
		
	}
	public Adminuserpage clicksubmitButton()
	{
		pg.javascriptclick(submitbutton, driver);
		return this;
	}
	public boolean successfullAlertMessage()
	{
		 return alertmessage.isDisplayed();
	}
	public Adminuserpage clicksearchButton()
	{
		pg.javascriptclick(searchbutton, driver);
		return this;
	}
	public Adminuserpage enterUserNameInUserNameFieldSearch(String username)
	{
		usernameinsearch.sendKeys(username);
		return this;
	}
	public Adminuserpage selectUserTypeInUserTypeFieldInSearch()
	{
		pg.selectDropdownWithVisibleText(usertypeinsearch, "Admin");
		return this;
		
	}
	public Adminuserpage clicksubmitsearchButton()
	{
		pg.javascriptclick(submitbuttonsearch, driver);
		return this;
	}
	public boolean elementSearchinTable()
	{
		
		return tablesearch.isEnabled();

	
	
	}
	
		 
	
	public Adminuserpage clickupdateButton()
	{
		 pg.javascriptclick(updatebutton, driver);
		return this;
	}
	public Adminuserpage enterUserNameInUserNameFieldUpdate(String username)
	{
		usernameupdate.sendKeys(username);
		return this;
	}
	public Adminuserpage clicksubmitButtonUpdate()
	{
   pg.javascriptclick(submitbuttoninupdate, driver);
return this;
	}

	public boolean successfullAlertMessageupdate()
	{
		 return alertmessageinupdate.isDisplayed();
	
	}
	public Adminuserpage clickDeleteButton()
	{
	 pg.javascriptclick(deletebutton, driver);
		pg.acceptalert(driver);
		return this;
	}
	public boolean successfullAlertMessageInDelete()
	{
		 return alertmessageindelete.isDisplayed();
	}
	
	
	
}
