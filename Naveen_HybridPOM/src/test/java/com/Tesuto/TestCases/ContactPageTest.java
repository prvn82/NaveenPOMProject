package com.Tesuto.TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Tesuto.Pages.ContactsPage;
import com.Tesuto.Pages.HomePage;
import com.Tesuto.Pages.LoginPage;
import com.Tesuto.TestBase.TestBase;
import com.Tesuto.TestData.TestData;

public class ContactPageTest extends TestBase {
	
	
	private LoginPage login;
	private HomePage home;
	private ContactsPage contact;
	
	
	@BeforeClass
	public void setup() {
		
		login = new LoginPage();
		home = login.Login(Config.getProperty("username"), Config.getProperty("password"));
		contact=home.clickOnContacts();
		
	}
	
	
	@Test(dataProvider="TestData",dataProviderClass=TestData.class)
	public void validateEnterContactDetailsTest(String title,String fname,String lname) {
		contact.clickOnNewContact();
		contact.enterNewContactDetails(title,fname,lname);
	}

}
