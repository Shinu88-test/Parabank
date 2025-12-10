package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Login {
	

	By registerbtn = By.xpath("//p/a[text()='Register']");
	
	private WebDriver driver;
	
	// Constructor to initialize driver	
	 public Login(WebDriver driver) {
		 this.driver=driver;
		 
			 }
	 
	public void VerifyPageTitle () {
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "ParaBank";
		if (actualTitle.equals(expectedTitle)) {
			
			System.out.println("Page Title matches");
		}
		
		else
		{
			System.out.println("Page Title doesnot match");
		}
		
		
	}
	
	 // Method to click on register, returns Register page object	
	public Register ClickRegisterbtn () {
		
		driver.findElement(registerbtn).click();
			return new Register (driver); // navigate to Register page object
	}

}
