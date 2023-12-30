package com.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class googleDemo 
{
	@Test
	public void testA() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains("Gogle"),"Title did not match");
		driver.close();
	}
}
