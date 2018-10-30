package com.Tesuto.TestCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Tesuto.Pages.HomePage;
//import org.testng.AssertJUnit;
import com.Tesuto.Pages.LoginPage;
import com.Tesuto.TestBase.TestBase;

public class LoginPageTest extends TestBase {
	
	private LoginPage login;
	
	HomePage home ;
	
	@BeforeClass
	public void Setup() {
		 login = new LoginPage();
	}
	
	@Test(priority=1)
	public void validateLoginPageTilteTest() {
		
		System.out.println(login);
		
		assertEquals(login.validateLoginPageTile(), "#1 Free CRM software in the cloud for sales and service");
		
	}
	
	
	@Test(priority=2)
	public void validateCRMImageTest() {
		
		assertTrue(login.validateCRMImage());
		
	}
	
	@Test(priority=3)
	public void LoginTest() throws InterruptedException {
		
		home =login.Login(Config.getProperty("username"), Config.getProperty("password"));
	}

}
