package testcases;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import excelexport.ReadExcel;
import operation.ReadObject;
import operation.UIOperation;

public class DriverScript_ff 
{
	@Test
    public void testLogin() throws Exception 
	{
		//System.setProperty("webdriver.gecko.driver", "D:\\Selenium_PPTs\\Software\\geckodriver-v0.16.1-win64\\geckodriver.exe");
		WebDriver webdriver = new FirefoxDriver();
		webdriver.manage().window().maximize();
		//System.setProperty("webdriver.gecko.driver", "D:\\Selenium_PPTs\\Software\\chromedriver_win32\\chromedriver.exe");
		//WebDriver webdriver = new FirefoxDriver();
		//webdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		ReadExcel file = new ReadExcel();
		ReadObject object = new ReadObject();
		Properties allObjects = object.getObjectRepository();
		UIOperation operation = new UIOperation(webdriver);
		//Read keyword sheet
   		//Sheet sheet = file.readExcel(System.getProperty("user.dir"),"KeywordSheet.xlsx", "Sheet1");
   		Sheet sheet = file.readExcel(System.getProperty("user.dir"),"HybridExcel.xlsx", "Sheet1");
		//Find number of rows in excel file
		int rowCount = sheet.getLastRowNum();
		//System.out.println(rowCount);
		//Create a loop over all the rows of excel file to read it
		for (int i = 1; i <=rowCount; i++) 
		{
			//Loop over all the rows
			Row row = sheet.getRow(i);
			
			//Check if the first cell contain a value, if yes, That means it is the new testcase name
			//if(row.getCell(0).toString().length()==0)
			if(row.getCell(0)==null || row.getCell(0).toString().length()==0)
			{
				//Print testcase detail on console
				System.out.println(row.getCell(1).toString()+"----"+ row.getCell(2).toString()+"----"+row.getCell(3).toString()+"----"+ row.getCell(4).toString());
				//Call perform function to perform operation on UI
				operation.perform(allObjects, row.getCell(1).toString(), row.getCell(2).toString(), row.getCell(3).toString(), row.getCell(4).toString());
			
			}
			else
			{
				//Print the new testcase name when it started
                System.out.println("New Testcase->"+row.getCell(0).toString() +" Started");
            }
			Thread.sleep(5000);
			
			
        }
		webdriver.close();
    }

}
