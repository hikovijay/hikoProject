package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input[id='user_email']")
	WebElement Email;
	
	@FindBy(css="input[id='user_password']")
	WebElement Password;
	
	@FindBy(css="input[value='Log In']")
	WebElement LogIn;
	
	
	public WebElement Email() {
		return Email;
	}
			
	public WebElement Password() {
		return Password;
	}
	
	public WebElement LogIn() {
		return LogIn;
	}
	
	
	
}
