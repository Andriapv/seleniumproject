package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility { //for html report generate 
	
	
	
	public static final ExtentReports extentReports = new ExtentReports(); 
	public synchronized static ExtentReports createExtentReports()//act as html report 
	{    
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");//specify file path where the report saved
		
		reporter.config().setReportName("Groceryapplication");  		//attach configurations where adding systm levl information to report
        extentReports.attachReporter(reporter);  
		extentReports.setSystemInfo("Organization", "Obsqura");  
		extentReports.setSystemInfo("Name", "Andria ");
		return extentReports;
	}

}
