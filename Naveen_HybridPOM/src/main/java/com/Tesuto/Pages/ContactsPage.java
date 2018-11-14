package com.Tesuto.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.Tesuto.TestBase.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	private WebElement Contactslink;

	@FindBy(xpath = "//a[@title='New Contact']")
	private WebElement NewContact;
	
	@FindBy(xpath="//select[@name='title']")
	private WebElement titleObj;
	
	@FindBy(xpath="//input[@name='first_name']")
	private WebElement FirstNameObj;
	
	
	@FindBy(xpath="//input[@value='Load From Company']//following::input[@type='submit' and @value='Save']")
	private WebElement SaveBtn;
	
	
	@FindBy(xpath="//input[@name='surname']")
	private WebElement lastNameObj;
	
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickOnNewContact() {

		Actions act = new Actions(driver);
		act.moveToElement(Contactslink).build().perform();
		
		NewContact.click();
	}
	
	public void enterNewContactDetails(String titleName,String FirstName,String lastName) {
		
		Select sel = new Select(titleObj);
		
		sel.selectByValue(titleName);
		
		//titleObj.sendKeys(titleName);
		FirstNameObj.sendKeys(FirstName);
		lastNameObj.sendKeys(lastName);
		SaveBtn.click();
		
	}

}
