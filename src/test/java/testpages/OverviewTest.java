package testpages;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.Login;
import pages.Overview;
import utilities.Excelutils;


public class OverviewTest extends BaseTest {
	
	  @DataProvider(name = "loginData")
	    public Object[][] getLoginData() throws Exception {
	        return Excelutils.getExcelData("D:\\automation\\Parabank.demo\\Testdata", "TestData.xlsx");
	    }
	
@Test(dataProvider = "loginData")

	public void EnterCredentials (String username, String password) {
		
		Login loginPage = new Login(driver);
		Overview overview = new Overview(driver) ;
		overview.enterusername(username);
		overview.enterpassword(password);
		overview.clickonlogin();
		
	}
	
	
	

}
