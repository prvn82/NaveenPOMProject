package com.Tesuto.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TestBase {
	
	//All basic Properties and Enviroments Details. 
	// Make Changes in this class on High request. It is master class for this F
	
	
	public static WebDriver driver ;
	
	public static Properties Config;
	
	
	@BeforeTest
	public static void initialization() throws Exception {
		
		try {
			
			//Reading Main Config File.
			
			File f = new File(System.getProperty("user.dir")+"/src/main/java/com/Tesuto/Config/config.properties");
			
			FileInputStream fs = new FileInputStream(f);
			
			Config = new Properties();
			
			Config.load(fs);
			
			}catch(FileNotFoundException e) {
				e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}
		
		
		String BrowserName = Config.getProperty("BrowerName");
		
		if(BrowserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/prakumak/Desktop/SeleniumWorld/chromedriver");
			driver = new ChromeDriver();
			driver.manage().window().setSize(new Dimension(1920, 1200));
		}
		else if(BrowserName.equalsIgnoreCase("Firefox")) {
			
			
			System.setProperty("webdriver.gecko.driver", "/Users/prakumak/Desktop/SeleniumWorld/geckodriver");

			
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			
		}
		else if(BrowserName.equalsIgnoreCase("IE")) {
			
			driver = new InternetExplorerDriver();
		}else {
			throw new Exception("Invalid Browser Name");
		}
		
		
		//driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(Integer.valueOf(Config.getProperty("ImplicitWait")), TimeUnit.SECONDS);
		
		
		driver.get(Config.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Integer.valueOf(Config.getProperty("ImplicitWait")), TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	
		
	}
	
//	@AfterTest
//	public void CloseDriver() {
//		if(driver!=null) {
//			driver.quit();
//		}
//	}

}
