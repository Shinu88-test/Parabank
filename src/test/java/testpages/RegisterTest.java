package testpages;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.Login;
import pages.Register;
public class RegisterTest extends BaseTest {
	
	
	
	
    @Test(priority = 1)
    public void EnterCustomerDetails () {
    	
    	Login loginPage = new Login(driver);
    	// Click Register button on Login page, get Register page object
    	Register register = loginPage.ClickRegisterbtn();
		register.enterFirstName( "USER");
		register.enterLastName("Test");
		register.enterAddress("test", "Kochi", "test", 565788);
		register.enterPhonenum(2345454);
		register.enterSSN(0000);
		register.entercredentials("USER", "ONE","ONE");
		register.clickonregister();
		register.getpagetitle();

		
		
	}


}
