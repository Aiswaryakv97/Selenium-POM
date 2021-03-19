package com.stackroute.seleniumPOM.TestPages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.stackroute.seleniumPOM.pages.DashboardPage;
import com.stackroute.seleniumPOM.pages.LoginPage;
import com.stackroute.seleniumPOM.pages.SearchPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchPageTest 
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
		public void searchTest() throws Exception
		{
			loginPage = new LoginPage(wd);
			
			PageFactory.initElements(wd, loginPage);
			SearchPage searchPage = loginPage.validLogin1("aiswaryakviyer@gmail.com", "aiswarya97");
			
			PageFactory.initElements(wd, searchPage);
			searchPage = searchPage.searchSuccess("java","Trivandrum");
			Thread.sleep(2000);
			assertTrue(wd.getCurrentUrl().contains("https://www.monsterindia.com/srp/results?query=java&locations=Trivandrum"));
			
						
			
		}
}
