package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	public WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="div[class='sumome-react-svg-image-container']")
	WebElement PopupClose;
	
	@FindBy(css="a[href*='sign_in']")
	WebElement Login;
	
	@FindBy(css=".text-center>h2")
	WebElement Title;
	
	@FindBy(css="a[href='contact.php']")
	WebElement Contact;
	
	
	public WebElement PopupClose() {
		return PopupClose;
	}
			
	public WebElement Login() {
		return Login;
	}
	
	public WebElement Title() {
		return Title;
	}
	
	public WebElement Contact() {
		return Contact;
	}
}
