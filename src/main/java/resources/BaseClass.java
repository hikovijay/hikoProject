package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class BaseClass {
	
public static WebDriver driver;//scope of driver object dies if its inside the loop, ststic soo driver refers to driver until cleared or nulled, also another class cannot modify driver
public Properties prop;

	public WebDriver InitialiseDriver() throws IOException{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\vijay\\Git\\HikoProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		
		String BrowserName = prop.getProperty("browser");
		
		if(BrowserName.equals("Chrome")) {
			//Chrome set property
			
			System.setProperty("webdriver.chrome.driver" , "C:\\Users\\vijay\\Git\\Dependencies\\Drivers\\chromedriver.exe" );
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.addArguments("--disable-notifications");
			driver =new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// depends on page size and images etc
		}
		
		else if (BrowserName.equals("Firefox")) {
			//Firefox Property
			 System.setProperty("webdriver.gecko.driver", "C:\\Users\\vijay\\Git\\Dependencies\\Drivers\\geckodriver.exe");
		     driver = new FirefoxDriver();
		     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// depends on page size and images etc
		}
		
		else if (BrowserName.equals("Edge")) {
			//IE Property
			System.setProperty("webdriver.edge.driver", "C:\\Users\\vijay\\Git\\Dependencies\\Drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// depends on page size and images etc
		}
		
		return(driver);
	}
	
	public void getScreenshot(String result) throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File ("C:\\Users\\vijay\\Desktop\\"+result+"screenshot.png"));
	}
	
	
	
}
