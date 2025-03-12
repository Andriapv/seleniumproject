package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Constants;
import pages.Homepage;
import pages.Loginpage;
import pages.Managecontactpage;
import utilities.Pageutility;

public class Managecontacttest extends Base {
	Loginpage login;
	Homepage home;
	Pageutility pg = new Pageutility();
	Managecontactpage managecontact;

	 @DataProvider(name = "contactData")
	    public Object[][] contactData() {
	        return new Object[][] {
	            { "1234567890", "test@example.com", "123 Main St", "9 AM", "5 PM" },  // Sample data set
	            // Add more data sets as required
	        };
	    }

	    
	@Test(dataProvider = "contactData")
	public void verifyUserIsAbleToupdateTheContactDetailsInManage(String number, String email, String address, String deliveryTime, String deliveryTimeLimit) throws IOException {
		login = new Loginpage(driver);
		home = login.loginUsingExceldata();
		managecontact = home.clickManageContactField().clickContactButton().updatePhoneNumberInPhoneNumberField(number)
				.updateEmailIdInEmailId(email).updateAddressInAddress(address)
				.updateDeliveryTimeInDeliveryTime(deliveryTime)
				.updateDeliveryTimeLimitInDeliveryTimelimit(deliveryTimeLimit).submitButtonInUpdateContact();
		boolean alert = managecontact.isalertpresent();
		Assert.assertTrue(alert, Constants.MC_MANAGECONTACT);
	}
}
