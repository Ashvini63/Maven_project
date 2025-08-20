package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home_page extends Base_page {
	 public Home_page(WebDriver driver){
		super(driver);
	}

	
	
// copy the element path	
@FindBy(xpath="//span[normalize-space()='My Account']")
		WebElement Myaccount;
	

@FindBy(xpath="//a[text()=\"Register\"]")
WebElement Ragister;


@FindBy(xpath="//a[normalize-space()='Login']")
WebElement login;





// Create action methods

    public void   click_Myaccount() {
	 Myaccount.click();

 }

   public  void click_ragister() {
	 Ragister.click();
 }

 public  void click_login() {
	 login.click();
 }

}







