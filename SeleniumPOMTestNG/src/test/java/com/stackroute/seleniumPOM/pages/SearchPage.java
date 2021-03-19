package com.stackroute.seleniumPOM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SearchPage
{
	
	WebDriver driver;
	WebElement SE_home_autocomplete;
	WebElement lmy;
	WebElement searchForm;
	
	public SearchPage(WebDriver driver) 
	{
		
		this.driver = driver;
				
	}
	
	public SearchPage searchSuccess(String skill, String location) throws Exception
	{

		Thread.sleep(3000);
		SE_home_autocomplete.sendKeys(skill);
		//password.sendKeys(password1);
		SE_home_autocomplete.click();
		Thread.sleep(4000);
		lmy.sendKeys(location);
		lmy.click();
		Thread.sleep(4000);
		searchForm.submit();
		
		return new SearchPage(driver);
		
		
	}
	
	
	

}
