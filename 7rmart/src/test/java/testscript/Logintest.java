package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationcore.Base;
import pages.Loginpage;

public class Logintest extends Base {
	@Test
	public void verifyUserLoginWithValidCredential() throws IOException {

		Loginpage lp = new Loginpage(driver);
		lp.loginUsingExceldata();
		boolean ishoempageloaded = lp.ishomepageloaded();
		Assert.assertTrue(ishoempageloaded, "Login failed with valid credential");

	}

	@Test
	public void verifyUserLoginWithValidUseranameAndInvalidPassword() {
		String username = "admin";
		String password = "admidn";
		Loginpage lp = new Loginpage(driver);
		lp.enterusernameinusernamefield(username);
		lp.enterpasswordinpasswordfield(password);
		lp.clicksigninbutton();
		boolean isalertdisplayed = lp.isalertdisplayed();
		Assert.assertTrue(isalertdisplayed, "logged in with valid username and invalid password");

	}

	@Test
	public void verifyLoginwithInvalidUsernameAndValidpassword() {
		String username = "adim";
		String password = "admin";
		Loginpage lp = new Loginpage(driver);
		lp.enterusernameinusernamefield(username);
		lp.enterpasswordinpasswordfield(password);
		lp.clicksigninbutton();
		boolean isalertdisplayed = lp.isalertdisplayed();
		Assert.assertTrue(isalertdisplayed, "logged in with invalid username and valid password");
	}

	@Test(dataProvider = "data provider")
	public void verifyUserLoginWithInValidCredential(String username, String password) {
		Loginpage lp = new Loginpage(driver);
		lp.enterusernameinusernamefield(username);
		lp.enterpasswordinpasswordfield(password);
		lp.clicksigninbutton();
		boolean isalertdisplayed = lp.isalertdisplayed();
		Assert.assertTrue(isalertdisplayed, "logged in with invalid credential");
	}

	@DataProvider(name = "data provider")
	public Object[][] dataprovider() {
		return new Object[][] { { "ann", "123" }, { "annwin", "456" }, { "jiji", "789" }, { "amil", "987" } };
	}

}
