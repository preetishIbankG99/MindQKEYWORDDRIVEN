package operation;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import utility.CaptureScreenshot;

public class UIOperation 
{
	
	WebDriver driver;
	
    public UIOperation(WebDriver driver)
    {
    	this.driver = driver;
    }  
    
    
    public void perform(Properties p,String operation,String ObjectName,String ObjectType,String value) throws Exception
    {
    	   	
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);      	
    	    	
    //	System.out.println("");
        switch (operation.toUpperCase()) 
        {
        
        case "GOTOURL":
            //Get url of application
              	driver.get(p.getProperty(value));             	
            	break; 
        
        case "SETTEXT":
            //Set text on control
            driver.findElement(this.getObject(p,ObjectName,ObjectType)).sendKeys(value);            
            break;
            	
        case "CLICK":
            //Perform click
          
        	driver.findElement(this.getObject(p,ObjectName,ObjectType)).click();        	
            break;
        	       
           case "SELECT":
        	Select x = new Select(driver.findElement(this.getObject(p, ObjectName, ObjectType)));
        	x.selectByVisibleText(value);
        	
       default:
            break;
        }
    }
    
   private By getObject(Properties p,String ObjectName,String ObjectType) throws Exception{
        //Find by xpath
        if(ObjectType.equalsIgnoreCase("XPATH")){
            
            return By.xpath(p.getProperty(ObjectName));
        }
        //find by class
        else if(ObjectType.equalsIgnoreCase("CLASSNAME")){
            
            return By.className(p.getProperty(ObjectName));
            
        }
        //find by name
        else if(ObjectType.equalsIgnoreCase("NAME")){
            
            return By.name(p.getProperty(ObjectName)); //By.name("userName")
            
        }
        //Find by css
        else if(ObjectType.equalsIgnoreCase("CSS")){
            
            return By.cssSelector(p.getProperty(ObjectName)); 
            
        }
        //find by link
        else if(ObjectType.equalsIgnoreCase("LINKTEXT")){
            
            return By.linkText(p.getProperty(ObjectName)); //By.linkText(""SIGN-OFF);
            
        }
        //find by partial link
        else if(ObjectType.equalsIgnoreCase("PARTIALLINK")){
            
            return By.partialLinkText(p.getProperty(ObjectName));
            
        }
        else
        {
            throw new Exception("Wrong object type");
        }
    }  

}
