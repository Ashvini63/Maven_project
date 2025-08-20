package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class My_account_page extends Base_page{

	public My_account_page(WebDriver driver) {
		super(driver);
	}		

	@FindBy(xpath="//h2[normalize-space()='My Account']")
     WebElement my_accountpage;
	
 

	@FindBy(xpath="//div[@class='list-group']//a[text()='Logout']")
     WebElement logout;

public boolean isMyAccountPageExists()   // MyAccount Page heading display status
{
	try {
		return (my_accountpage.isDisplayed());
	} catch (Exception e) {
		return (false);
	}
}
public void clicklogout() {
	logout.click();
}

}
	
	


