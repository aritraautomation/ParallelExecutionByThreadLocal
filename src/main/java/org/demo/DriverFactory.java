package org.demo;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
	
	private DriverFactory(){
		//Do not allow to initialize this class from outside
	}

	private static DriverFactory instance = new DriverFactory();
	
	public static DriverFactory getInstance(){
		return instance;
	}
	
	//thread local driver object for WebDriver
	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	//call this method to get the driver object and launch the browser
	public WebDriver getDriver(){
		return driver.get();
	}
	
	public void setDriver(WebDriver driverParam){
		driver.set(driverParam);		
	}
	
	public void removeDriver(){
		driver.get().quit();
		driver.remove();
		
	}
	
}
