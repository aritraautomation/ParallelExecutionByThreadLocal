package org.parallelExecTest;

import org.demo.BaseTest;
import org.demo.BrowserFactory;
import org.demo.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class SearchTest extends BaseTest{
	
	//public WebDriver driver=null;
	
	/*@BeforeTest
	@Parameters({"browser"})
	public void setUp(String browser){
	
		driver = BrowserFactory.createInstance(browser);
		DriverFactory.getInstance().setDriver(driver);
		driver = DriverFactory.getInstance().getDriver();		
	}*/
	
	@Test
	@Parameters({"search"})
	public void searchCases(String search) throws InterruptedException{
		/*driver.manage().window().maximize();
		driver.get("http://www.google.com");*/
		
		WebElement searchBox = driver.findElement(By.name("q"));
		
		Thread.sleep(3000);
		searchBox.sendKeys(search);	
		
		searchBox.sendKeys(Keys.ENTER);		
	}
	
	/*@AfterTest
	public void tearDown(){
		DriverFactory.getInstance().removeDriver();
	}*/
	

}
