package com.Tesuto.Utlities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.Tesuto.TestBase.TestBase;

public class TestUtil extends TestBase {
	
	
	//private static long Page_load_timeout=10;
	//private static long Implicit
	
	
	public static void SwitchFrame(String framName) {
		
		driver.switchTo().frame(framName);
		
	}
	
	//ScreenShot method
	
	public static void takeScreenShot() throws Exception {
		File screenshotAs = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String Path=System.getProperty("user.dir")+"/ScreenShot/"+System.currentTimeMillis()+".png";
		
		FileUtils.copyFile(screenshotAs, new File(Path));
	}

}
