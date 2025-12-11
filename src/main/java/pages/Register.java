package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.util.Assert;


public class Register {
	
	WebDriver driver;
	//WebDriver wait;
	 
	String firstName = "input[id='customer.firstName']";
	String lastName = "input[id='customer.lastName']";
	String address= "input[id='customer.address.street']";
	String city = "input[id='customer.address.city']";
	String state = "input[id='customer.address.state']";
	String zipcode ="input[id='customer.address.zipCode']";
	String phonenum = "input[id='customer.phoneNumber']";
	String ssn = "input[id='customer.ssn']";
	String username = "input[id='customer.username']";
	String password = "input[id='customer.password']";
	String confirm = "input[id='repeatedPassword']";
	By registerbtn = By.xpath("//input[@type='submit' and @value='Register']");
		
	
	 
	  // Constructor to initialize driver
	    public Register(WebDriver driver) {
	        this.driver = driver;
	    }
	 
public void enterFirstName(String firstname) {
		 
		 driver.findElement(By.cssSelector(firstName)).sendKeys(firstname);

		}
public void enterLastName(String lastname) {
		 
		 driver.findElement(By.cssSelector(lastName)).sendKeys(lastname);

		}
	 
public void enterAddress(String Address,String City, String State, int Zip) {
		 
		 driver.findElement(By.cssSelector(address)).sendKeys(Address);
		 driver.findElement(By.cssSelector(city)).sendKeys(City);
		 driver.findElement(By.cssSelector(state)).sendKeys(State);
		 driver.findElement(By.cssSelector(zipcode)).sendKeys(String.valueOf(Zip));

		} 
public void enterPhonenum(int phonenumber) {
	
	driver.findElement(By.cssSelector(phonenum)).sendKeys(String.valueOf(phonenumber));
	
}

public void enterSSN(int ssnumber) {
	
	driver.findElement(By.cssSelector(ssn)).sendKeys(String.valueOf(ssnumber));
	
}
public void entercredentials(String Username, String Password, String RePassword) {
	
	driver.findElement(By.cssSelector(username)).sendKeys(Username);
	driver.findElement(By.cssSelector(password)).sendKeys(Password);
	driver.findElement(By.cssSelector(confirm)).sendKeys(RePassword);

}

public void clickonregister() {
	
	driver.findElement(registerbtn).click();
}	 



public void getpagetitle() {
	// TODO Auto-generated method stub

	String actualTitle = driver.getTitle();
	String expectedTitle = "Welcome test";


	
}


	 }



