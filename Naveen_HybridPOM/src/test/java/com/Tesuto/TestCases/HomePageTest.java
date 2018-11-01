package com.Tesuto.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Tesuto.Pages.HomePage;
import com.Tesuto.Pages.LoginPage;
import com.Tesuto.TestBase.TestBase;
import com.Tesuto.Utlities.TestUtil;

public class HomePageTest extends TestBase {

	private LoginPage login;
	private HomePage home;

	@BeforeClass
	public void Setup() {

		login = new LoginPage();
		home = login.Login(Config.getProperty("username"), Config.getProperty("password"));

	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		System.out.println(home.verifyHomePageTitle());
		Assert.assertEquals(home.verifyHomePageTitle(), "CRMPRO", "HomePage Title does not match");
	}

	@Test(priority = 2)
	public void validateUserNameLableTest() {
		//TestUtil.SwitchFrame("mainpanel");

		Assert.assertTrue(home.validateUserNameLable());
	}
	
//	@Test(priority=3)
//	public void clickOnContactsTest() {
//		home.clickOnContacts();
//		//return new ContactsPage();
//	}
	
	
}
