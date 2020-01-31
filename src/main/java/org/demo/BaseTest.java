package org.demo;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {
	
	public WebDriver driver = null;
	
	@BeforeTest
	@Parameters({"browser","url"})

	public void setUp(String browser, String url) throws InterruptedException{
		
		driver = BrowserFactory.createInstance(browser);
		DriverFactory.getInstance().setDriver(driver);
		driver = DriverFactory.getInstance().getDriver();
		driver.manage().window().maximize();
		driver.get(url);
		Thread.sleep(5000);
	}

	
	@AfterTest
	public void tearDown(){
		DriverFactory.getInstance().removeDriver();
	}
}
