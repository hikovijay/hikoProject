package Hiko;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import resources.BaseClass;

public class ValidateTitle extends BaseClass{
	public static Logger log = LogManager.getLogger(BaseClass.class.getName());
	@BeforeTest
	public void Initialize() throws IOException {
		driver = InitialiseDriver();
		}
	
	
	@Test
	public void ValidateAppTitle() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("src\\main\\java\\resources\\data.properties");
		prop.load(fis);		
		LandingPage l = new LandingPage(driver);
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home Page");
		Assert.assertEquals(l.Title().getText(), "FEATURED COURSES");
		Assert.assertTrue(l.Contact().isDisplayed()	); 
		log.info("Successfully Validated Text Message");
		
	}
	
	@AfterTest
	public void teardown(){
		driver.close();
		driver=null;
	}
	
}
