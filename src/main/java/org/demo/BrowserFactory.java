package org.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	public static WebDriver createInstance(String browser)
	{
		WebDriver driver = null;
		
		try {
			if(browser.equalsIgnoreCase("chrome")){
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("firefox")){
				System.setProperty("webdriver.gecko.driver", "/Automation/ParallelExecutionDemo/lib/geckodriver.exe");
				driver = new FirefoxDriver();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			return driver;
		}
		return driver;
	}
}
