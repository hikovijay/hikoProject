package Hiko;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.BaseClass;

public class HomePage extends BaseClass{
public static Logger log = LogManager.getLogger(BaseClass.class.getName());

	@BeforeTest
	public void Initialize() throws IOException {
		driver = InitialiseDriver();
		}
	
	@Test(dataProvider = "getData")
	public void LogInCheck(String Username , String Password,String text) throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\vijay\\Git\\HikoProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		//WebDriverWait wait=new WebDriverWait(driver, 20);
		//wait.until(ExpectedConditions.visibilityOf(l.PopupClose()));
		//l.PopupClose().click();
		LandingPage l = new LandingPage(driver);
		LoginPage h = new LoginPage(driver);
		
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home Page");
		l.Login().click();
		
		h.Email().sendKeys(Username);
		h.Password().sendKeys(Password);
		h.LogIn().click();
		log.info("Successfully Validated Username and Password");
		log.info(text);
				
		}
	
	@AfterTest
	public void teardown(){
		driver.close();
		driver = null;
	}
	
	@DataProvider(name = "getData")
	public Object[][] getData(){
		Object[][] data = new Object[2][3];
		data[0][0]="abc.jk@gmail.com";
		data[0][1]="vk678";
		data[0][2]="Restricted User";
				
		data[1][0]="abc.gh@gmail.com";
		data[1][1]="2kjhs3";
		data[1][2]="Non Restricted User";
				
		return data;
		}
			
}
