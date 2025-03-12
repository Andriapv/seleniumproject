package pages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utilities.FileUploadingUtility;
import utilities.Pageutility;
import utilities.Waitutility;

public class Categorypage {
	public WebDriver driver;
	 Pageutility pg=new  Pageutility() ;
     Waitutility wait =new  Waitutility();
     FileUploadingUtility fileupload=new FileUploadingUtility();
	public Categorypage(WebDriver driver)
	{
		 this.driver = driver;    
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Category/add']") WebElement createnewcategorybutton;
	@FindBy(xpath="//input[@id='category']") WebElement categoryfield ;
	@FindBy(xpath="//li[@id='134-selectable']") WebElement selectgroupdiscountdraganddrop1 ;
	@FindBy(xpath="//li[@id='134-selection']") WebElement selectgroupdiscountdraganddrop2;
	@FindBy(xpath="//input[@id='main_img']") WebElement choosefile;
	@FindBy(xpath="//button[@class='btn btn-danger']") WebElement savebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement alertmessage;
	@FindBy(xpath="//i[@class='fa fa-search']") WebElement searchbutton;
	@FindBy(xpath="//input[@class='form-control']") WebElement categoryfieldinsearch;
	@FindBy(xpath="//button[@type='submit']") WebElement searchsubmitbutton;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tr/td[1]") List <WebElement> elementsearch;
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-primary btncss']") WebElement updatebutton;
	@FindBy(xpath="//input[@id='category']") WebElement categoryfieldinupdate;
	@FindBy(xpath="//button[@type='submit']") WebElement submitbuttonupdate;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement successfullalertinupdate;
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-danger btncss']") WebElement deletebuttonincategory;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement successfullalertindelete;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-warning']") WebElement resetbutton;
	
	public Categorypage clickCreateNewCategory()
	{
		createnewcategorybutton.click();
		return this;
	}
	public Categorypage enterCategoryInCategoryField(String newcategory)
	{
		categoryfield.clear();
		categoryfield.sendKeys(newcategory+pg.generateCurrentDateAndTime());
		return this;
	}
	public Categorypage selectTheSelectGroup()
	{
		
		pg.javascriptclick(selectgroupdiscountdraganddrop1, driver);
		return this;
		
		
	}
	public Categorypage clickChooseFile()
	{
		
	
		fileupload.fileuploadusingsendkeys(choosefile,Constants.C_FILEPATH);
		return this;
	}
	public Categorypage clickSaveButton()
	{
	
		pg.javascriptclick(savebutton, driver);
		return this;
	}
	public String generateCurrentDateAndTime() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyhhmmss");
		return formatter.format(date);
	}
	public boolean alertmessage()
	{
		
		return alertmessage.isDisplayed();
	}
	public Categorypage clickSearchButtonInSearch()
	{  
		pg.javascriptclick(searchbutton, driver);
		return this;
		
	}
	public Categorypage enterCategoryInCategoryFieldsearch(String category)
	{
		categoryfieldinsearch.sendKeys(category);
		return this;
	}
	public Categorypage clickSubmitButtonInSearch()
	{  
         pg.javascriptclick(searchsubmitbutton, driver);
		return this;
	}
	public boolean elementSearchinginCategory() 
	{
		return pg.elementSearching(elementsearch, "one");
		
	}	
	public Categorypage clickupdateTheCategory()
	{
		 pg.javascriptclick(updatebutton, driver);
		return this;
	}
	public Categorypage enterCategoryFieldinUpdate(String categoryfieldupdate)
	{
		
		categoryfieldinupdate.clear();
		categoryfieldinupdate.sendKeys(categoryfieldupdate);
		return this;
	}
	public Categorypage clicksubmitButtoninUpdate()
	{
		pg.javascriptclick(submitbuttonupdate, driver);
		return this;	
		}
	public boolean alertMessageInUpdate()
	{
		
		return successfullalertinupdate.isDisplayed();
	}
	public Categorypage deleteTheCategoryField()
	{
		
		pg.javascriptclick(deletebuttonincategory, driver);
		pg.acceptalert(driver);
		return this;
	}
	public boolean alertMessageInDelete()
	{
		return successfullalertindelete.isDisplayed();
	}
	
	

}
