package com.qa.TestBase;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.qa.Utilites.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBaseClass {

	
public static Logger log;
	
	public WebDriver driver;
	
	ReadConfig rc=new ReadConfig();
	public String readUrl=rc.readData();
	
	@BeforeMethod
	public void launchBrowser() {
		log=LogManager.getLogger(TestBaseClass.class);
		String browser="Chrome";
		
		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.info("chrome browser launched successfully");
		} else if (browser.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			log.info("firefox browser launched successfully");
		}else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			log.info("edge browser launched successfully");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(readUrl);
	}
	
	@AfterMethod
	public void closeBrowser() {
		
		driver.quit();
	}
	
	public void screenshot(WebDriver driver, String tname) {
		
		try {
			TakesScreenshot ts=(TakesScreenshot)driver;
			File source=ts.getScreenshotAs(OutputType.FILE);
			File dest=new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
			FileUtils.copyFile(source, dest);
			log.info("Screenshot taken successfully");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
}
