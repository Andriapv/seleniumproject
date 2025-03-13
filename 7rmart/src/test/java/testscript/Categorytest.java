package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Constants;
import pages.Categorypage;
import pages.Homepage;
import pages.Loginpage;
import utilities.Pageutility;

public class Categorytest extends Base {
	Loginpage login;
	Homepage home;
	Pageutility pg = new Pageutility();
	Categorypage category;

	@Test
	public void verifyUserIsAbleTocreateNewCategory() throws IOException {
		login = new Loginpage(driver);
		home = login.loginUsingExceldata();
		String categoryname = "sling bag";
		category = home.clickCategoryField().clickCreateNewCategory().enterCategoryInCategoryField(categoryname)
				.selectTheSelectGroup().clickChooseFile().clickSaveButton();
		boolean alertmessage = category.alertmessage();
		Assert.assertTrue(alertmessage, Constants.C_CATEGORY);
	}

	@Test
	public void verifyUserIsAbleTosearchCategory() throws IOException {
		login = new Loginpage(driver);
		home = login.loginUsingExceldata();
		String categoryname = "Beetroot";
		category = home.clickCategoryField().clickSearchButtonInSearch()
				.enterCategoryInCategoryFieldsearch(categoryname).clickSubmitButtonInSearch();
		boolean search = category.elementSearchinginCategory();
		Assert.assertTrue(search, Constants.C_CATEGORYSEARCH);
	}

	@Test
	public void verifyUserIsAbleToupdateTheCategoryField() throws IOException {
		login = new Loginpage(driver);
		home = login.loginUsingExceldata();
		String categorynameupdate = "sling bag";
		category = home.clickCategoryField().clickupdateTheCategory().enterCategoryInCategoryField(categorynameupdate)
				.clicksubmitButtoninUpdate();
		boolean alertmessage = category.alertMessageInUpdate();
		Assert.assertTrue(alertmessage, Constants.C_CATEGORYUPDATE);
	}

	@Test
	public void verifyUserIsAbleTodeleteTheCategoryField() throws IOException {
		login = new Loginpage(driver);
		home = login.loginUsingExceldata();
		category = home.clickCategoryField().deleteTheCategoryField();
		boolean alertmessage = category.alertMessageInDelete();
		Assert.assertTrue(alertmessage, Constants.C_CATEGORYDELETE);
	}

}
