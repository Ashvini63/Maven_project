package test_case;

import org.testng.Assert;
import org.testng.annotations.Test;


import page_objects.Home_page;
import page_objects.Login_page;
import page_objects.My_account_page;
import test_base.Test_base;

public class Tc002_loginTest extends Test_base {

	  @Test(groups= {"regression","Master"})
	  
	  public void  login_varification() {
		  
try {
      logger.info("**** Starting TC_002_LoginTest  ****");
	  
	  Home_page page2=new Home_page (driver);
	  page2.click_Myaccount();
	  page2.click_login();
	  
	  
	  Login_page lp_page= new  Login_page(driver);	  
	  lp_page.setemail(prop.getProperty("email"));
	  lp_page.setpassword(prop.getProperty("password"));
	  lp_page.click_loginbutton();
	  
	  
	   My_account_page acc_page=  new My_account_page(driver);
	    boolean target_page=acc_page. isMyAccountPageExists();
	     Assert.assertEquals(target_page,true);
		  }
	
		  
 catch(Exception e)
	{
		Assert.fail();
	}
	
	logger.info("**** Finished TC_002_LoginTest  ****");
	  
	  

	 }}
