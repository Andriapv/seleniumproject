package testscript;

import java.awt.AWTException;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import automationcore.Base;
import constants.Constants;
import pages.Homepage;
import pages.Loginpage;
import pages.Subcategorypage;
import utilities.Pageutility;

public class Subcategorytest extends Base {
	Loginpage login;
	Homepage home;
	Pageutility pg = new Pageutility();
	Subcategorypage subcategory;

	@Test
	public void verifyUserIsAbleTocreateSubcategoryWithValidDetails() throws AWTException, IOException {
		login = new Loginpage(driver);
		home = login.loginUsingExceldata();
		String subcategoryname = "Beef burger" + pg.generateCurrentDateAndTime();
		subcategory = home.clickSubCategoryField().clickCreateNewSubCategory()
				.selectCategoryfromCategoryListInCategoryField().entersubcategoryinsubcategoryfield(subcategoryname)
				.clickChooseFileField().clicksavebutton();
		boolean alertdisplayed = subcategory.successfullalertmessage();
		Assert.assertTrue(alertdisplayed, Constants.LP_VERIFYLOGINWITHVALIDCREDENTIAl);

	}

	@Test
	public void verifyUserIsAbleTosearchTheCreatedSubcategoryInSearchbar() throws IOException {
		login = new Loginpage(driver);
		home = login.loginUsingExceldata();
		String subcategoryname = "beef burger";
		subcategory = home.clickSubCategoryField().clicksearchbutton().selectCategoryInSearchCategoryField()
				.enterSubCategoryInSubCategoryField(subcategoryname).clicksearchsubmitbutton();
		boolean isElementPresent = subcategory.elementsearching();
		Assert.assertTrue(isElementPresent, Constants.SC_SUBCATEGORY);
	}

	@Test
	public void verifyUserIsAbleToUpdateTheSubcategoryDetails() throws IOException {
		login = new Loginpage(driver);
		home = login.loginUsingExceldata();
		String subcategorynameinupdate = "cheesy Beef burger";
		subcategory = home.clickSubCategoryField().clickUpdateButtonInsubcategoryListTable()
				.selectCategoryfromCategoryListInCategoryField()
				.enterSubCategoryInSubCategoryFieldinUpdate(subcategorynameinupdate).changeImageinChooseFileinUpdate()
				.clickUpdateButton();
		boolean updatedalertmessage = subcategory.successfulupdateAlertMessage();
		Assert.assertTrue(updatedalertmessage, Constants.SC_UPDATETHESUBCATEGORY);
	}

	@Test
	public void verifyUserIsAbleToDeleteButtonInSubcategoryTable() throws IOException {
		login = new Loginpage(driver);
		home = login.loginUsingExceldata();
		subcategory = home.clickSubCategoryField().clickDeleteButton();
		boolean deletemessagealert = subcategory.successfullDeteletedMessageAlert();
		Assert.assertTrue(deletemessagealert, Constants.SC_CLICKDELETEBUTTON);
	}
}
