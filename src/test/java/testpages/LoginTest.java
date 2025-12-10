package testpages;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.Login;
import pages.Register;


public class LoginTest extends BaseTest {
	
	
@Test	
	public void ClickOnRegister() {
		
		Login login =new Login (driver);
		login.VerifyPageTitle();
		login.ClickRegisterbtn();
		
	
	}
	
	
	
	

}
