package org.demo;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

public class Utility {
	
	public static void takeElementScreesnhot(WebElement element, String fileName)
	{
		File srcFile = element.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File("./target/screenshot/" + fileName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
