package com.Tesuto.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
//import org.apache.poi.hslf.model.Sheet;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.Tesuto.Utlities.WebDriverListener;
import com.aventstack.extentreports.ExtentTest;

public class TestBase {

	// All basic Properties and Enviroments Details.
	// Make Changes in this class on High request. It is master class for this F

	private final static String TestDataPath = System.getProperty("user.dir") + "/src/test/resources/FreeCRMData.xlsx";

	public static WebDriver driver;

	public static Properties Config;

	private static FileInputStream file = null;
	
	protected static Workbook book;
	protected static Sheet sheet;
	
	public ExtentTest test;
	
	public ExtentTest createNode;
	
	protected static Logger log;
	
	protected static WebDriverListener edriver;
	protected static EventFiringWebDriver eventListener;
	
	
	public static void TestBase() {
		// TODO Auto-generated constructor stub
		
		try {

			file = new FileInputStream(new File(TestDataPath));

			// Reading Main Config File.

			File f = new File(System.getProperty("user.dir") + "/src/main/java/com/Tesuto/Config/config.properties");

			FileInputStream fs = new FileInputStream(f);

			Config = new Properties();

			Config.load(fs);
			//Setup for WebdriverListenere
			
			//log = logger
			
			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@BeforeTest
	public static void initialization() throws Exception {

		

		String BrowserName = Config.getProperty("BrowerName");

		if (BrowserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/prakumak/Desktop/SeleniumWorld/chromedriver");
			driver = new ChromeDriver();
			driver.manage().window().setSize(new Dimension(1920, 1200));
		} else if (BrowserName.equalsIgnoreCase("Firefox")) {

			System.setProperty("webdriver.gecko.driver", "/Users/prakumak/Desktop/SeleniumWorld/geckodriver");

			driver = new FirefoxDriver();
			driver.manage().window().maximize();

		} else if (BrowserName.equalsIgnoreCase("IE")) {

			driver = new InternetExplorerDriver();
		} else {
			throw new Exception("Invalid Browser Name");
		}

		
		eventListener = new EventFiringWebDriver(driver);
		edriver = new WebDriverListener();
		eventListener.register(edriver);
		driver=eventListener;

		driver.get(Config.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Integer.valueOf(Config.getProperty("ImplicitWait")),
				TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

	}

	@AfterTest
	public void CloseDriver() {
		if(driver!=null) {
			driver.quit();
		}
	}

}
