package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Constants;
import pages.Homepage;
import pages.Loginpage;
import pages.Managenewspage;
import utilities.Pageutility;

public class Managenewstest extends Base  {
	Loginpage login;
	Homepage home;
	Pageutility pg = new Pageutility();
	Managenewspage Managenews;
  @Test
  public void verifyUserIsAbleTocreateNewsInManageNews() throws IOException
  {
	  login = new Loginpage(driver);
	  home = login.loginUsingExceldata();
	  
	  Managenews= home.clickManageNewsButton().clickAddNewofManageNewsButton().addNewsinNewsField("Manage news in admin users").clicksaveButtoninNewsField();
	  boolean alert=Managenews.alertMessage();
	  Assert.assertTrue(alert,Constants.MN_MANAGENEWS);
	  
  }
  @Test
  public void verifyUserIsAbleToSearchNewsUsingSearchButton() throws IOException
  {
	  login = new Loginpage(driver);
	  home = login.loginUsingExceldata();
	  Managenews=home.clickManageNewsButton().clicksearchButtoninManageNews().searcNewsinSearchField("hello").clickSubmitButtoninSearch();
	  boolean search=Managenews.iselementpresentintable();
	  Assert.assertTrue(search, Constants.MN_MANAGENEWSSEARCH);
	  
  }
  @Test
  public void verifyUserIsAbleToDeleteNewsinManageNews() throws IOException
  {
	  login = new Loginpage(driver);
	  home = login.loginUsingExceldata();
	  Managenews= home.clickManageNewsButton().clickDeleteButton();
	  boolean alert=Managenews.alertMessageInDelete();
	  Assert.assertTrue(alert,Constants.MN_MANAGENEWSDELETE);
  }
  
}
