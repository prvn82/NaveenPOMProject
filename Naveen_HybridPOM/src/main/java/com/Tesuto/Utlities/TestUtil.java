package com.Tesuto.Utlities;

import com.Tesuto.TestBase.TestBase;

public class TestUtil extends TestBase {
	
	
	//private static long Page_load_timeout=10;
	//private static long Implicit
	
	
	public static void SwitchFrame(String framName) {
		
		driver.switchTo().frame(framName);
		
	}

}
