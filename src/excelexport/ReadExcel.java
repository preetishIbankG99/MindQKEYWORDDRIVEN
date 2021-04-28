package excelexport;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;



import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcel 
{
	 public Sheet readExcel(String filePath,String fileName, String sheetName) throws IOException
	 {
		 File file = new File(filePath+"\\"+fileName);
		

		FileInputStream inputStream = new FileInputStream(file);
		
		
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);
		 //Read sheet inside the workbook by its name
		 XSSFSheet sh = wb.getSheet(sheetName);
		 return sh;		 
	 } 		 
}
