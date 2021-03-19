package com.stackroute.seleniumPOM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage 
{
	WebDriver driver;
	
	WebElement signInName;
	WebElement password;
	WebElement signInbtn;
	WebElement spanMessage;
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		System.out.println(driver.getCurrentUrl());
	}

	
	public DashboardPage validLogin(String username1, String password1) throws Exception
	{
		signInName.sendKeys(username1);
		password.sendKeys(password1);
		signInbtn.click();
		
		return new DashboardPage(driver);
		
	}
	
	public SearchPage validLogin1(String username1, String password1) throws Exception
	{
		signInName.sendKeys(username1);
		password.sendKeys(password1);
		signInbtn.click();
		
		return new SearchPage(driver);
		
	}
	
	public String invalidLogin(String username1, String password1) throws Exception
	{

		signInName.sendKeys(username1);
		password.sendKeys(password1);
		signInbtn.click();
		
		return spanMessage.getText();
	}
	
	
	
	
}








