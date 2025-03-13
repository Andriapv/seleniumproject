package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Pageutility;
import utilities.Waitutility;

public class Managenewspage {

	public WebDriver driver;
	Pageutility pg = new Pageutility();
	Waitutility wait = new Waitutility();

	public Managenewspage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add']")
	WebElement newbuttonmanagenews;
	@FindBy(xpath = "//textarea[@class='form-control']")
	WebElement newstextareafield;
	@FindBy(xpath = "//button[@name='create']")
	WebElement savebuttoninmanagenews;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertmessage;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchbutton;
	@FindBy(xpath = "//input[@name='un']")
	WebElement searchfield;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchsubmitbutton;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tr//td[1]")
	List<WebElement> tablesearch;
	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-danger btncss']")
	WebElement deletebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertmessageindelete;

	public Managenewspage clickAddNewofManageNewsButton() {
		pg.javascriptclick(newbuttonmanagenews, driver);
		return this;
	}

	public Managenewspage addNewsinNewsField(String news) {
		newstextareafield.sendKeys(news);
		return this;
	}

	public Managenewspage clicksaveButtoninNewsField() {
		pg.javascriptclick(savebuttoninmanagenews, driver);
		return this;
	}

	public boolean alertMessage() {
		return alertmessage.isDisplayed();
	}

	public Managenewspage clicksearchButtoninManageNews() {
		pg.javascriptclick(searchbutton, driver);
		return this;
	}

	public Managenewspage searcNewsinSearchField(String search) {
		searchfield.sendKeys(search);
		return this;
	}

	public Managenewspage clickSubmitButtoninSearch() {
		pg.javascriptclick(searchsubmitbutton, driver);
		return this;
	}

	public boolean iselementpresentintable() {
		return pg.elementSearching(tablesearch, "hello");
	}

	public Managenewspage clickDeleteButton() {
		pg.javascriptclick(deletebutton, driver);
		pg.acceptalert(driver);
		return this;
	}

	public boolean alertMessageInDelete() {
		return alertmessageindelete.isDisplayed();
	}

}
