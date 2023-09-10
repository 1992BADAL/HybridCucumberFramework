package Factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	
	static WebDriver driver = null;
	
	public static WebDriver initializeBrowser(String browserName) {
		
		if(browserName.equals("chrome")) {
			ChromeOptions co = new ChromeOptions();
			co.addArguments("--remote-allow-origins=*");
			co.addArguments("use-fake-ui-for-media-stream");
			driver = new ChromeDriver(co);
			 //driver = new ChromeDriver();
			
		}else if(browserName.equals("firefox")) {
			 driver = new FirefoxDriver();
			
		}else if(browserName.equals("edge")) {
			 driver = new EdgeDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver;
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	
}
