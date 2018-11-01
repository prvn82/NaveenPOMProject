package com.Tesuto.TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Tesuto.Pages.ContactsPage;
import com.Tesuto.Pages.HomePage;
import com.Tesuto.Pages.LoginPage;
import com.Tesuto.TestBase.TestBase;

import sun.util.logging.resources.logging;

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
	
	@Test
	public void validateEnterContactDetailsTest() {
		contact.clickOnNewContact();
		contact.enterNewContactDetails("Miss", "Praveen1", "Kumar1");
	}

}
