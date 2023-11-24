package DropDown;


import java.time.Duration;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
public class check_dropdown {
	
	public static WebDriver  driver;
	public  static WebDriverWait wait;
	
	// verify dropdown in sorted options
	
public static void main(String[] args) throws InterruptedException {
    	
		WebDriverManager.chromedriver().setup();
		ChromeOptions options= new ChromeOptions();
		options.addArguments("Start-maximized");
		options.addArguments("--remote-allow-origins=*");
		options.setExperimentalOption("excludeSwitches", Collections.singleton("enable-automatiom"));
	    driver= new ChromeDriver(options);
	//	driver.get("http://127.0.0.1:5500/dropdowns/single.html");
		   driver.get("http://127.0.0.1:3000/dropdowns/Multiple.html");
		
//		driver.findElement(By.xpath("//a[text()='Live Posting']")).click();
		
         //  	    WebElement drplist=	driver.findElement(By.id("Player"));	
           	    WebElement drplist=	driver.findElement(By.id("Team"));	
	            Select sec= new Select(drplist);
	
	            List<WebElement>ele=  sec.getOptions();
	            
	            
	            ArrayList <String>originalList= new ArrayList<>();
	         
	
	            for (WebElement eles : ele)
	            {
	            	
	            	 originalList.add(eles.getText());
        //             templist.add(eles.getText());		
			    }
	            
	            System.out.println("originallist "+originalList.toString());
	        
	            
	            ArrayList<String> templist= new ArrayList<>();
	            
	            templist=        originalList;
	            
	            System.out.println("templistBeforeSort "+templist.toString()); 
	            
	            Collections.sort(templist);
	            
	            System.out.println("templistAfterSort "+templist.toString()); 
	            
	      //      System.out.println("originallist "+originalList);
	     //       System.out.println("templist "+templist);
	            
	            if(originalList.equals(templist)) {
	            	System.out.println("dropdown sorted");
	            	
	            }
	            else {
	            	System.out.println("dropdown not sorted");
	            }
	            Thread.sleep(5000);
	            driver.quit();
	            }

}
