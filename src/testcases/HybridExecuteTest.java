package testcases;




import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import excelexport.ReadExcel;
import operation.ReadObject;
import operation.UIOperation;

public class HybridExecuteTest {
	WebDriver webdriver = null;
	@Test(dataProvider="hybridData")
	    public void testLogin(String TestCase,String operation,String ObjectName,String ObjectType,String value) throws Exception {
	        
	      
	    if(TestCase!=null&&TestCase.length()!=0){
	    webdriver=new FirefoxDriver();
	    }
	ReadObject object = new ReadObject();
	Properties allObjects = object.getObjectRepository();
	UIOperation uioperation = new UIOperation(webdriver);
	    //Call perform function to perform operation on UI
	            uioperation.perform(allObjects, operation, ObjectName,
	            		ObjectType, value);
	    
	    }
	@DataProvider(name="hybridData")
	    public Object[][] getDataFromDataprovider() throws IOException{
	    Object[][] object = null;
	    ReadExcel file = new ReadExcel();
	//Read keyword sheet
	Sheet sheet = file.readExcel(System.getProperty("user.dir"),"HybridExcel.xlsx","Sheet1");
	//Find number of rows in excel file
	    int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
	    object = new Object[rowCount][5];
	    for (int i = 0; i < rowCount; i++) {
	        //Loop over all the rows
	        Row row = sheet.getRow(i+1);
	        //Create a loop to print cell values in a row
	        for (int j = 0; j < row.getLastCellNum(); j++) {
	            //Print excel data in console
	            object[i][j] = row.getCell(j).toString();
	        }
	    }
	    System.out.println("");
	     return object;    
	    }
}
