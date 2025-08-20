package test_case;

//import java.time.Duration;

import page_objects.Account_ragistration_page;
import page_objects.Home_page;
import test_base.Test_base;


import org.testng.Assert;

import org.testng.annotations.Test;


public class TC_01_Ragistartion_test extends Test_base{
	
 @Test(groups = {"sanity","Master"})
     public void verified_accontragistration() {
	 // for homepage
  try {
	    logger.info("**Starting the test**");
	 
	     Home_page page = new Home_page(driver);
    	 page.click_Myaccount();
         page.click_ragister();
    	  logger.info(" click on registration");
     // registration page
         Account_ragistration_page ragistration_page = new  Account_ragistration_page(driver);
         // ragistration_page.setFirstName("Manasi");
         ragistration_page.setFirstName(randomeString().toUpperCase());
          
          //ragistration_page.setLastName("Mali");
          ragistration_page.setLastName(randomeString().toUpperCase());
          
          //ragistration_page.setEmail("Manasi1234@gmail.com");
          ragistration_page.setEmail(randomeString()+"@gmail.com");
          
          //ragistration_page.setTelephone("7226654878");
          ragistration_page.setTelephone( randomeNumbers());
          
          //ragistration_page.setPassword("Man@1234");
          //ragistration_page.setConfirmPassword("Man@1234");
           
          String password =randomeAlphaNumeric();
           
           ragistration_page.setPassword(password);
           ragistration_page.setConfirmPassword(password);
          
           logger.info(" providing cutomer details");
          ragistration_page.setPrivacyPolicy();
          ragistration_page. clickContinue();
          logger.info("validting reagistration massage");
           
           String massage =ragistration_page.getConfirmationMsg(); 
         // for fail test case use below if else and check see the error log
           
           /*if(massage.equals("Your Account Has Been Created!!!")) {
             Assert.assertTrue(true);
          }
          
          else {
        	  logger.error("test failed");
        	  logger.debug("debug logs..");
        	  Assert.assertTrue(false);
          }*/
       Assert.assertEquals(massage,"Your Account Has Been Created!");
    	  }
 catch(Exception e) {
    		  logger.error("test failed.."+ e.getMessage());
    		  logger.debug("debug logs.."+ e.getMessage());
    		  
    	  }
 finally {
     logger.info("**..test finished..**");
     }
 } 
 
   
}
   