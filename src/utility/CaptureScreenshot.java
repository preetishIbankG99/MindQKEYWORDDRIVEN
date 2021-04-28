package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureScreenshot 
{
	public void screenshot(WebDriver driver) throws IOException 
	{
		File x = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(x, new File("H:\\photonwp\\KDF_DEMO_STYLE1_R\\screenshot"+System.currentTimeMillis()+".jpg"));		
	}
}
