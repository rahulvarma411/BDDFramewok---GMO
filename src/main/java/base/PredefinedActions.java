package base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PredefinedActions {
	protected static WebDriver driver;
	public static int failedTest;
	public static int passedTest;
	public static int skippedTest;
	
	public void initialization() {
		//System.setProperty("webdriver.chrome.driver", ConstantPath.CHROMEDRIVERexe);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.borland.com/gmopost/");
	}
	
	public static String getTimestamp() {
		SimpleDateFormat simpledateformat = new SimpleDateFormat("ddMMyyyyhhmmss");
		Date date = new Date();
		String timestamp= simpledateformat.format(date);	
		return timestamp;
		
	}
	
	public static void getScreenShot(String filename ) throws IOException{
		String timestamp = getTimestamp();
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		File dest = new File (".//Snapshot//"+filename+timestamp+".png\"");
		FileUtils.copyFile(src, dest);		
	}
	
	public static void displayConsoleResult(){
		int totalTest = passedTest + failedTest;
		System.out.println("---------------------------------------------------------");
		System.out.println("Passed :"+passedTest+" Failed :"+failedTest+" Total :"+totalTest);
		System.out.println("---------------------------------------------------------");
	}

	@After
	public void tearDown(Scenario scenario) {
		TakesScreenshot sc = (TakesScreenshot)driver;
		byte []screenshot = sc.getScreenshotAs(OutputType.BYTES);
		scenario.embed(screenshot, "image/png");
		if(scenario.isFailed()) {
			failedTest++;
		}else {
			passedTest++;
		}
		
		displayConsoleResult();
		
		driver.quit();
	}
}
