package automationcore;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constants;
import utilities.Screenshotutility;
import utilities.Waitutility;

public class Base {
	Waitutility wait = new Waitutility();

	Properties prop;
	FileInputStream file;
	public WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void initializebrowser(String browser) throws Exception {
		prop = new Properties();
		file = new FileInputStream(Constants.CONFIGFILE);
		prop.load(file);
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		} else {
			throw new Exception("invalid browser");
		}
		driver.get(prop.getProperty("baseurl"));

		driver.manage().window().maximize();
		wait.implicitlyWait(driver);
	}

	@AfterMethod(alwaysRun = true)
	public void driverquit(ITestResult itestresult) throws IOException {

		if (itestresult.getStatus() == ITestResult.FAILURE) {
			Screenshotutility screenshot = new Screenshotutility();
			screenshot.getScreenshot(driver, itestresult.getName());
		}

		driver.quit();
	}
}
