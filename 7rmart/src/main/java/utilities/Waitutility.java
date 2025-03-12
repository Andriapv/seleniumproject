package utilities;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Waitutility {
	
	public static final int IMPLICITWAIT_DURATION=10;
	public static final int WAIT_DURATION=5;
	
	public void implicitlyWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITWAIT_DURATION));
	}

	public void fluentWaitElements(WebDriver driver, WebElement element, String attribute, String attributeValue,
			int total) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(total))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.attributeContains(element, attribute, attributeValue));
	}
	public void waitForWebElementAlert(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_DURATION));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	public void waitForElementtoBeClickable(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_DURATION));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void waitForInvisibilityOfElement(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_DURATION));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	public void waitForWebElemenToBeSelected(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_DURATION));
		wait.until(ExpectedConditions.elementToBeSelected(element));
		}
	public void waitForValueInElement(WebDriver driver, WebElement element, String expectedValue) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_DURATION));
	    wait.until(ExpectedConditions.textToBePresentInElementValue(element, expectedValue));
	}
	public void waitForFrameToBeAvailableAndSwitchToIt(WebDriver driver, By frameLocator) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_DURATION));
	    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}
	public void waitForAttributeToChange(WebDriver driver, WebElement element, String attribute, String expectedValue) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_DURATION));
	    wait.until(ExpectedConditions.attributeToBe(element, attribute, expectedValue));
	}
	public void waitForAlertToBePresent(WebDriver driver) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_DURATION));
	    wait.until(ExpectedConditions.alertIsPresent());
	}
	public void waitForTitleToContain(WebDriver driver, String titleSubstring) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_DURATION));
	    wait.until(ExpectedConditions.titleContains(titleSubstring));
	}
	public void waitForTextToBePresentInElement(WebDriver driver, WebElement element, String text) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_DURATION));
	    wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}
	public void waitForElementToBeEnabledButNotClickable(WebDriver driver, WebElement element) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_DURATION));
	    wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void waitForModalToAppear(WebDriver driver) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_DURATION));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal")));
	}
	public void waitForElementToBeEnabledWithCondition(WebDriver driver, WebElement element) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_DURATION));
	    wait.until(new ExpectedCondition<Boolean>() {
	        public Boolean apply(WebDriver driver) {
	            return element.isEnabled();
	        }
	    });
	}
	
	public void waitForElementToBeClickableByXpath(WebDriver driver, String xpath) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_DURATION));
	    wait.until(new ExpectedCondition<WebElement>() {
	        public WebElement apply(WebDriver driver) {
	            return driver.findElement(By.xpath(xpath));
	        }
	    });
	}
	public void waitForElementsPresence(WebDriver driver, List<By> locators) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_DURATION));
	    for (By locator : locators) {
	        wait.until(new ExpectedCondition<WebElement>() {
	            public WebElement apply(WebDriver driver) {
	                return driver.findElement(locator);
	            }
	        });
	    }
	}
	public void waitForWindowToBeOpened(WebDriver driver, String currentWindowHandle) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_DURATION));
	    wait.until(new ExpectedCondition<Boolean>() {
	        public Boolean apply(WebDriver driver) {
	            return driver.getWindowHandles().size() > 1;
	        }
	    });
	    Set<String> allWindows = driver.getWindowHandles();
	    allWindows.remove(currentWindowHandle);
	    driver.switchTo().window(allWindows.iterator().next());
	}



}
