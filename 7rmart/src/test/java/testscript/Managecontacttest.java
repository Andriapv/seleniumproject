package testscript;

import java.io.IOException;
import java.util.Date;
import org.testng.Assert;
import org.testng.annotations.Test;
import automationcore.Base;
import pages.Homepage;
import pages.Loginpage;
import pages.Managecontactpage;
import utilities.Fakerutility;
import utilities.Pageutility;

public class Managecontacttest extends Base {
	Loginpage login;
	Homepage home;
	Pageutility pg = new Pageutility();
	Managecontactpage managecontact;
	Fakerutility fakerUtility = new Fakerutility();

	@Test
	public void verifyUserIsAbleToUpdateTheContactDetailsInManage() throws IOException {

		String fakePhoneNumber = fakerUtility.generatePhoneNumber();
		String fakeEmail = fakerUtility.generateemail();
		String fakeAddress = fakerUtility.generateAddress();
		Date fakeDate = fakerUtility.generatedate();
		long randomNumber = fakerUtility.generaterandomNumber();

		login = new Loginpage(driver);
		home = login.loginUsingExceldata();
		managecontact = home.clickManageContactField().clickContactButton()
				.updatePhoneNumberInPhoneNumberField(fakePhoneNumber).updateEmailIdInEmailId(fakeEmail)
				.updateAddressInAddress(fakeAddress).updateDeliveryTimeInDeliveryTime(fakeDate.toString())
				.updateDeliveryTimeLimitInDeliveryTimelimit(String.valueOf(randomNumber)).submitButtonInUpdateContact();

		boolean alert = managecontact.isalertpresent();
		Assert.assertTrue(alert, "Alert not displayed after updating contact details");
	}
}
