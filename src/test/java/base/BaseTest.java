package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import listeners.ExtentReportListener;

public class BaseTest {
	
	
	protected WebDriver driver;
	WebDriver wait;
	
	@BeforeMethod	
	public void driverSetup() {
		
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://parabank.parasoft.com/parabank/index.html");	
		ExtentReportListener.setDriver(driver);
	}
	
	@AfterMethod
	public void teardown() {
		
		if (driver != null) {
	          driver.quit();
	      }
		
		
	}
	

}
