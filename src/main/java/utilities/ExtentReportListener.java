package utilities;

import java.io.File;

import org.apache.maven.surefire.shared.utils.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ExtentReportListener implements ITestListener  {
	
	    private static ExtentReports extent;
	    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
	    private static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

	    @Override
	    public void onStart(ITestContext context) {
	        extent = ExtentManager.getExtentReports();
	        System.out.println("Test Suite started: " + context.getName());
	    }

	    @Override
	    public void onTestStart(ITestResult result) {
	        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
	        extentTest.set(test);
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        String screenshotPath = captureScreenshot(result.getMethod().getMethodName());
	        extentTest.get().pass("Test Passed");
	        extentTest.get().addScreenCaptureFromPath(screenshotPath);
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	        extentTest.get().fail(result.getThrowable());
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        extentTest.get().skip("Test Skipped: " + result.getThrowable());
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	        extent.flush();
	    }
	 // Screenshot method
	    private String captureScreenshot(String testName) {
	        try {
	            WebDriver driver = driverThread.get();

	            if (driver == null) {
	                System.out.println("Driver is null for screenshot");
	                return null;
	            }

	            String timestamp = String.valueOf(System.currentTimeMillis());
	            String screenshotDir = System.getProperty("user.dir") + "/screenshots/";
	            File directory = new File(screenshotDir);

	            if (!directory.exists()) {
	                directory.mkdirs();
	            }

	            String filePath = screenshotDir + testName + "_" + timestamp + ".png";

	            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	            FileUtils.copyFile(src, new File(filePath));

	            return filePath;

	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	    // Static to set driver
	    public static void setDriver(WebDriver driver) {
	        driverThread.set(driver);
	    }
	}

	
	
