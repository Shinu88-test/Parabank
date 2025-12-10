package utilities;

import org.testng.ITestListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class ExtentManager {
	
	
	    private static ExtentReports extentReports; // UI of the report
	    public static ExtentSparkReporter htmlReporter; // populate common info on the report
	    public static ExtentTest test; // creating testcase entries in the report and update status of the test methods

	    public static ExtentReports getExtentReports()
	    
	    {
	    	
	    	 if (extentReports == null)
	    	 
	    	 {
	            ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
	            spark.config().setDocumentTitle("Automation Report"); //Title of the report
	            spark.config().setReportName("Functional Testing");
	            extentReports = new ExtentReports();         
	            extentReports.attachReporter(spark);
	            extentReports.setSystemInfo("Tester", "Shinshinu");
	            extentReports.setSystemInfo("Environment", "QA");
	            extentReports.setSystemInfo("Browser name", "Chrome");
	          
	        }
	        return extentReports;
	    }

	
	
	}



