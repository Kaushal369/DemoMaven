package com.qa.PagesTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.gmail.pages.LoginPage;
import com.qa.gmail.test.TestBase;

public class LoginTest extends TestBase {
	public LoginTest() throws Throwable {
		super();
		// TODO Auto-generated constructor stub
	}
	LoginPage lg ;
	@BeforeMethod
	public void Setup() throws Throwable {
		
		initialization();
		
		lg = new LoginPage();
	}
	@Test(priority=1)
	public void verify_Test_Title()
	{
		lg.verifyTitle(p.getProperty("title"));
		System.out.println("Verify_Test_title Is Verified and This Test Is Passed !!!! ");
	}
	
	@Test(priority=2)
	public void verifyLogo()
	{
		lg.verifyLogoDisplayOrNot();
		System.out.println("=============Logo Test Passed Successfully !!!!");
	}
	
	
	@Test(priority=3)
	public void LoginTest()
	{
		lg.LogIn(p.getProperty("userNames"), p.getProperty("Pwd"));
		System.out.println("=========Login Test Passed Successfully !!! =========");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	}

