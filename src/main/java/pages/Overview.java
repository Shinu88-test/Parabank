package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Overview {
	
	By opennewaccnt = By.xpath("//li[a=\"Open New Account\"]");
	By usernametxtbox = By.xpath("//input[@name='username']");
	By passwordtxtbox = By.xpath("//input[@name='password']");
	By loginbtn = By.xpath("//input[@value='Log In']");
	
	
	WebDriver driver;
	
	public Overview (WebDriver driver) {
		
		this.driver = driver;
	}
	public void enterusername (String username) {
		
		driver.findElement(usernametxtbox).sendKeys(username);
	}
	
	public void enterpassword (String password) {
		
		driver.findElement(passwordtxtbox).sendKeys(password);
	}
	
	public void clickonlogin() {
		
		driver.findElement(loginbtn).click();
	}
	
	public void clickonNewaccnt () {
		
		driver.findElement(opennewaccnt).click();
	}

}
