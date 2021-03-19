package com.stackroute.seleniumPOM.TestPages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.stackroute.seleniumPOM.pages.DashboardPage;
import com.stackroute.seleniumPOM.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DashboardPageTest
{
	static WebDriver wd;
	 
	LoginPage loginPage= null;
		
		@BeforeClass
		public static void init()
		{
			
			//System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
			WebDriverManager.chromedriver().setup();

			wd = new ChromeDriver();
			
			wd.manage().window().maximize();
			wd.get("https://www.monsterindia.com/rio/login");
			
		}
		

		@Test
		public void logoutTest() throws Exception
		{
			loginPage = new LoginPage(wd);
			
			PageFactory.initElements(wd, loginPage);
			DashboardPage dbPage = loginPage.validLogin("aiswaryakviyer@gmail.com", "aiswarya97");
			
			PageFactory.initElements(wd, dbPage);
			loginPage = dbPage.logoutSuccess();
			Thread.sleep(2000);
			assertTrue(wd.getCurrentUrl().equals("https://www.monsterindia.com/rio/sign-out"));
			
			
			
		}
}











