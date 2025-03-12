package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


public class Screenshotutility {
	public void getScreenshot(WebDriver driver, String failedtestcase) throws IOException {
		TakesScreenshot scrShot = (TakesScreenshot) driver;  	//take screenshot is a interface,web driver is cast to take screenshot interface	
File screenShot = scrShot.getScreenshotAs(OutputType.FILE); //we capture ss and store in temp path,for that a file is created,getss is a method   
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());  
		File f1 = new File(System.getProperty("user.dir") + "//OutputScreenShot");   //creating new file,user.dir(project path),folder name output screenshot in current directory
		if (!f1.exists()) {//if f1 is not already existed,then it will create folder
			f1.mkdirs();    //mkdir --> will create folder using java
		}
		String destination = System.getProperty("user.dir") + "//outputScreenShot//" + failedtestcase + timeStamp
				+ ".png";//to understand which ss is that
		File finalDestination = new File(destination);//copying from temp path to folder
		FileHandler.copy(screenShot, finalDestination);	

	}

}
