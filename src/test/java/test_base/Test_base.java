package test_base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.apache.commons.lang3.RandomStringUtils;

import org.apache.logging.log4j.LogManager;//log4j
import org.apache.logging.log4j.Logger;   //log4j

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Test_base {
	 public  static WebDriver driver; 
	 public Logger logger;
	 public Properties prop;
	 @BeforeClass(groups= {"sanity","regression","Master"})
	 @Parameters({"os","browser"})
	 public void setup(String os,String br) throws IOException {
    
		 FileInputStream file=new FileInputStream("C:\\Users\\HP\\eclipse-workspace\\Maven_project\\src\\test\\resources\\config.properties");
		 prop=new Properties();
		 prop.load(file);
		 
		 
		 logger=LogManager.getLogger(this.getClass());//Log4j
		
		 // for remote
		 if (prop.getProperty("execution_env").equalsIgnoreCase("remote")) {
			 
			 DesiredCapabilities capabilites =new DesiredCapabilities();
			  
			 //os
			 if(os.equalsIgnoreCase("windows")) {
				  capabilites.setPlatform(Platform.WIN11);
			  }
			  else  if (os.equalsIgnoreCase("Linux")) {
				  capabilites.setPlatform(Platform.LINUX);
			  }
			  else {
				  System.out.println("no matching os");
				  return;
			  }
		 
		 //browser
		 switch(br.toLowerCase()) {
		 case "chrome": capabilites.setBrowserName("chrome");
		 break;
		 case "edge": capabilites.setBrowserName("edge");
		 break;
		 case "firefox": capabilites.setBrowserName("firefox");
		 break;
		 default:  System.out.println("no matching browser"); 
		 return;
		 
		 }
		  driver = new RemoteWebDriver(new URL("http://172.24.208.1:4444/wd/hub"),capabilites);
	} 
		 
		 
		 
		 
	//local	 
		 
		 if (prop.getProperty("execution_env").equalsIgnoreCase("local")) {
		       switch(br.toLowerCase()) {
		      case "chrome":driver= new ChromeDriver();break;
		      case "edge":driver= new EdgeDriver();break;
		      default: System.out.println("Invalid broswer"); return;
		 }
		
		  }
		 
		 
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get(prop.getProperty("url")); // redding data from proprties file
	driver.manage().window().maximize();
	}
	 
	@AfterClass(groups= {"sanity","regression","Master"})
	   public  void teardown() {
		 driver.quit();
	 }
	     

	   // for random data providation 
	   public String randomeString() {
		   String generate_String = RandomStringUtils.randomAlphabetic(5);
	    return generate_String ;
	   
	   }
	   public String randomeNumbers() {
		   String generate_String = RandomStringUtils.randomNumeric(10);
	    return generate_String ;
	   
	  }

	   public String randomeAlphaNumeric() {
		   String str= RandomStringUtils.randomAlphabetic(3);
	    
	    String number = RandomStringUtils.randomNumeric(4);
	    return (str +"@" +number);
	   }   
	    public String captureScreen (String tname)throws IOException {

			//String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new java.util.Date());
			
					
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
			
			String targetFilePath=System.getProperty("user.dir")+"\\screenshot\\" + tname + "_" + timeStamp + ".png";
			File targetFile=new File(targetFilePath);
			
			sourceFile.renameTo(targetFile);
				
			return targetFilePath;

		}

	   }



