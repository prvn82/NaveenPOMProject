package com.Tesuto.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Tesuto.TestBase.TestBase;

public class HomePage extends TestBase {
	
	
	@FindBy(xpath="//td[contains(text(),'PRAVEEN KUMAR')]")
	private WebElement userNameLable;
	
	//a[contains(text(),'Contacts')]
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	private WebElement Contactslink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	private WebElement DealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	private WebElement Taskslink;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions of Page
	
	public String verifyHomePageTitle() {
		
		return driver.getTitle();
		
	}
	
	public boolean validateUserNameLable() {
		return userNameLable.isDisplayed();
	}
	
	//pub
	public ContactsPage clickOnContacts() {
		Contactslink.click();
		return new ContactsPage();
	}
	
	
	public DealsPage clickOnDeals() {
		DealsLink.click();
		return new DealsPage();
	}
	
	
	
	
	
	
	

}
