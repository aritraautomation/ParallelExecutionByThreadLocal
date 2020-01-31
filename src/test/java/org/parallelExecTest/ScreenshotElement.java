package org.parallelExecTest;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.demo.BaseTest;
import org.demo.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotElement extends BaseTest {
	
		Utility screenshot = new Utility();
	
	
		@Test
		public void screenshotDemo() throws InterruptedException{		
		
		
		WebElement email = driver.findElement(By.cssSelector("input[id=username]"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement logIn = driver.findElement(By.id("loginBtn"));
		WebElement forgetLink = driver.findElement(By.linkText("Forgot my password"));
		//WebElement hupSpotForm = driver.findElement(By.xpath("//*[@id='hs-login'][0]"));
		//WebElement hupSpotForm = driver.findElement(By.xpath("//form"));
		Thread.sleep(3000);

		
		email.sendKeys("aritras@gmail.com");
		password.sendKeys("aritras@gmail.com");
		
		
		screenshot.takeElementScreesnhot(email,"email");
		screenshot.takeElementScreesnhot(password,"password");
		screenshot.takeElementScreesnhot(forgetLink,"forgetLink");
		screenshot.takeElementScreesnhot(logIn,"logIn");
		//takeElementScreesnhot(hupSpotForm,"hupSpotForm");
		
		//driver.quit();
	}

	/*public static void takeElementScreesnhot(WebElement element, String fileName)
	{
		File srcFile = element.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File("./target/screenshot/" + fileName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/
}	
