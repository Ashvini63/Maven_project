package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_page  extends Base_page{

	public Login_page(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement Enteremail;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginbutton;
	

 public void setemail(String email) {
	 Enteremail.sendKeys(email);
 }

 public void setpassword(String pwd) {
	 password.sendKeys(pwd);
 }
   
 public void click_loginbutton() {
	 loginbutton.click(); ;
 }
}