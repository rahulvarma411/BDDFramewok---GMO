package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PredefinedActions {
	protected static WebDriver driver;
	
	public void initialization() {
		//System.setProperty("webdriver.chrome.driver", ConstantPath.CHROMEDRIVERexe);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.borland.com/gmopost/");
	}
	
	
	public void tearDown() {
		driver.quit();
	}
}
