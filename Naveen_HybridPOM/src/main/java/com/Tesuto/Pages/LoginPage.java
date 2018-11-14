package com.Tesuto.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Tesuto.TestBase.TestBase;

public class LoginPage extends TestBase {
	
	
	
	// Object RO
	
	//UserName
	
	@FindBy(xpath="//input[@name='username']")
	WebElement username;
	
	//password
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	
	//input[@type='submit']
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement LoginBtn;
	
	//SignUp Button
	
	@FindBy(xpath="//a/font[text()='Sign Up']")
	WebElement SigeUp;
	
	@FindBy(xpath="//img[@alt='free crm logo1']")
	WebElement CRM_Logo;
	
	//Constructor intitialziing Page Object
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions of Page:
	
	//Validate Page URL
	public String validateLoginPageTile() {
		return driver.getTitle();
	}
	
	// VALIDATE PAGE LOGO
	public boolean validateCRMImage() {
		return CRM_Logo.isDisplayed();
	}
	//Login 
	public HomePage Login(String usernameDetails,String passwordDetails){
		
		//Thread.sleep(10000);
		
		//WebDriverWait wait = new WebDriverWait(driver, 20);
		//wait.until(ExpectedConditions.invisibilityOfElementLocated((By) LoginBtn));
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		username.sendKeys(usernameDetails);
		password.sendKeys(passwordDetails);
		jse2.executeScript("arguments[0].click()",LoginBtn);
		//LoginBtn.click();
		
		return new HomePage();
	}
	
	
	
	
	
	
	
	
	
}
