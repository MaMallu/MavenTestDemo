package com.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class UITest 
{
	@Test
	@Parameters({"browserName","url"})
	public void launchBrowser(@Optional("chrome") String browser,String url)
	{
		 System.out.println("Browser Name: "+browser);
		 WebDriver driver=null;
		 
		 if(browser.contains("chrome"))
		 {
			 ChromeOptions opt =new ChromeOptions();
			 opt.addArguments("----headless");
			 opt.addArguments("---no-sandbox");
			 opt.addArguments("--disable-dev-shm-usuage");
			 driver=new ChromeDriver(opt);
			 driver=new FirefoxDriver();
		 }
		 else if(browser.contains("firefox"))
		 {
			 driver=new FirefoxDriver();
		 }
		 driver.manage().window().maximize();
		 driver.get(url);
		 System.out.println(driver.getTitle());
		 Assert.assertTrue(driver.getTitle().contains("Facebook - log in or sign up"),"Title did not match");
		 driver.findElement(By.xpath("//input[@id='email']")).sendKeys("mallusreddy@gmail.com");
		 driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("mallumani");
		 driver.findElement(By.xpath("//*[@name='login']")).click();
		 driver.quit();
		 
	}
}
