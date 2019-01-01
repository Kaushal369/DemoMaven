package com.qa.gmail.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import com.qa.gmail.test.TestBase;

public class LoginPage extends TestBase {
 	
	@FindBy(name ="identifier")
	WebElement userName;
	
	@FindBy(className ="CwaK9")
	WebElement NextClickButton;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(id="passwordNext")
	WebElement clickOnLogin;
	
	@FindBy(id="logo")
	WebElement logo;
	
	
	
	public LoginPage() throws Throwable
	{ 
		PageFactory.initElements(driver, this);
	 }
	
	public void verifyTitle(String titles)
	{
		String title =	driver.getTitle();
		Assert.assertEquals(title, titles);
	}
	
	public void verifyLogoDisplayOrNot()
	{
		Assert.assertTrue(logo.isDisplayed());
	}
	
	
	public HomePage LogIn(String userNames, String Pwd)
	{
		userName.sendKeys(userNames);
		NextClickButton.click();
		password.sendKeys(Pwd);
		clickOnLogin.click();
		return new HomePage();
	}
	
	
}
