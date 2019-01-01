package com.qa.gmail.test;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	FileInputStream fis ;
	public static 	Properties p ;
	public static WebDriver driver;
	
	public TestBase() throws Throwable {
		fis = new FileInputStream("./config/config.properties");
		
		p = new Properties();
		p.load(fis);
	}
	
	public static void initialization()
	{
		String browser  =	p.getProperty("browser");
		if(browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
			if(browser.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "‪E:\\Software\\chromedriver.exe");
 				driver = new ChromeDriver();
			}
 		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
 		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

}
