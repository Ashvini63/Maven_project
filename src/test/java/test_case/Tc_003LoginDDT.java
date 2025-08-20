package test_case;

import org.testng.Assert;
import org.testng.annotations.Test;

import page_objects.Home_page;
import page_objects.Login_page;
import page_objects.My_account_page;
import test_base.Test_base;
import utilites.DataProviders;

public class Tc_003LoginDDT extends Test_base {
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class, groups="regression")
	public  void loginDDT(String email,String password,String result) {
	
	  logger.info("*****Starting the LoginDDT*****");
	  try {
	  Home_page page2=new Home_page (driver);
	  page2.click_Myaccount();
	  page2.click_login();

	
	  Login_page lp_page= new  Login_page(driver);	  
	  lp_page.setemail(email);
	  lp_page.setpassword(password);
	  lp_page.click_loginbutton();
	  
	  
	  
	My_account_page acc_page=  new My_account_page(driver);
	    boolean target_page=acc_page. isMyAccountPageExists();
	    
	    /* data is valid  login successes    test pass
	                       login failed      test fail
	    
	     data invalid=    login successes     test fail    
	    	              login failed         test pass*/
	    
	    
	    
	    if (result.equalsIgnoreCase("valid")) {
	    	  if(target_page==true) {
	    		  acc_page.clicklogout();
	    		  Assert.assertEquals(target_page,true);
	             }
	         else {
	    	     Assert.assertEquals(target_page,false);
	         }
	    }
	       
	    if    (result.equalsIgnoreCase("invalid")) {
		       if(target_page==true) {
   		       acc_page.clicklogout();
   		       Assert.assertEquals(target_page,false);}
   		  
	           else {
   			Assert.assertEquals(target_page,true);  
   		  }
	 }
	   }
            catch(Exception e) {
	          Assert.fail();
       }
	  logger.info("*****..Finished the LoginDDT..*****");
}

}






