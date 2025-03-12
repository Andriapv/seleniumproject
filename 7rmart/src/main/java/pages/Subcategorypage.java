package pages;

import java.awt.AWTException;
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

public class Subcategorypage {
	public WebDriver driver;
	Pageutility pg = new Pageutility();
	Waitutility wait = new Waitutility();
	FileUploadingUtility fileuploading = new FileUploadingUtility();

	public Subcategorypage(WebDriver driver)

	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Subcategory/add']")
	WebElement createnewsubcategorybutton;
	@FindBy(xpath = "//select[@name='cat_id']")
	WebElement categoryfield;
	@FindBy(xpath = "//input[@id='subcategory']")
	WebElement subcategoryfield;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement choosefilefield;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement savebutton;
	@FindBy(xpath = "//a[@class='btn btn-default btn-fix']")
	WebElement cancelbutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successfullalertmessage;
	@FindBy(xpath = "//a[@href='javascript:void(0)']")
	WebElement searchbutton;
	@FindBy(xpath = "//select[@id='un']")
	WebElement searchcategoryfield;
	@FindBy(xpath = "//input[@name='ut']")
	WebElement searchsubcategoryfield;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchsubmitbutton;
	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-primary btncss']")
	WebElement updatebutton;
	@FindBy(xpath = "//select[@id='cat_id']")
	WebElement categoryinupdate;
	@FindBy(xpath = "//input[@id='subcategory']")
	WebElement subcategoryinupdate;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement choosefilefieldinupdate;
	@FindBy(xpath = "//button[@name='update']")
	WebElement updatesubmitbutton;
	@FindBy(xpath = "//i[@class='fas fa-trash-alt']")
	WebElement deletebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successfulldeletealert;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tr//td")
	List<WebElement> tablesearch;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successfullalertsubcategoryupdate;

	public Subcategorypage clickCreateNewSubCategory() {
		createnewsubcategorybutton.click();
		return this;
	}

	public Subcategorypage selectCategoryinCategoryField() {
		pg.selectDropdownWithValue(categoryfield, "burger");
		return this;
	}

	public Subcategorypage entersubcategoryinsubcategoryfield(String subcategory) {
		subcategoryfield.sendKeys(subcategory);
		return this;
	}

	public Subcategorypage clickChooseFileField() throws AWTException {

		String filepath = Constants.IMAGEUPLOAD;
		fileuploading.fileuploadusingsendkeys(choosefilefield, filepath);
		return this;

	}

	public Subcategorypage clicksavebutton() {
		pg.javascriptclick(savebutton, driver);
		return this;
	}

	public boolean successfullalertmessage() {
		return successfullalertmessage.isDisplayed();
	}

	public String generateCurrentDateAndTime() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyhhmmss");
		return formatter.format(date);
	}

	public Subcategorypage clicksearchbutton() {
		searchbutton.click();
		return this;
	}

	public Subcategorypage selectCategoryInSearchCategoryField() {

		pg.selectDropdownWithVisibleText(searchcategoryfield, "burger");
		return this;

	}

	public Subcategorypage enterSubCategoryInSubCategoryField(String searchsubcategoryvalue) {
		searchsubcategoryfield.sendKeys(searchsubcategoryvalue);
		return this;
	}

	public Subcategorypage clicksearchsubmitbutton() {
		searchsubmitbutton.click();
		return this;
	}

	public boolean elementsearching() {
		String subcategory = "beef burger";
		boolean flag = false;
		if (tablesearch != null && !tablesearch.isEmpty()) {
			for (WebElement searching : tablesearch) {
				if (searching.getText().trim().equalsIgnoreCase(subcategory)) {
					flag = true;
					break;
				}
			}
		}

		return flag;
	}

	public Subcategorypage clickUpdateButtonInsubcategoryListTable() {

		pg.javascriptclick(updatebutton, driver);
		return this;
	}

	public Subcategorypage selectCategoryfromCategoryListInCategoryField() {

		pg.selectDropdownWithVisibleText(categoryinupdate, "burger");
		return this;
	}

	public Subcategorypage enterSubCategoryInSubCategoryFieldinUpdate(String subcategorynameinupdate) {
		subcategoryinupdate.clear();
		subcategoryinupdate.sendKeys(subcategorynameinupdate);
		return this;
	}

	public Subcategorypage changeImageinChooseFileinUpdate() {

		String filepath = Constants.SC_FILEPATH;
		fileuploading.fileuploadusingsendkeys(choosefilefieldinupdate, filepath);
		return this;
	}

	public Subcategorypage clickUpdateButton() {
		pg.javascriptclick(updatesubmitbutton, driver);
		return this;

	}

	public Subcategorypage clickDeleteButton() {
		pg.javascriptclick(deletebutton, driver);
		pg.acceptalert(driver);
		return this;
	}

	public boolean successfullDeteletedMessageAlert() {
		return successfulldeletealert.isDisplayed();

	}

	public boolean successfulupdateAlertMessage() {
		return successfullalertsubcategoryupdate.isDisplayed();

	}

}
