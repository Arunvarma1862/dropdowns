package DropDown;

import java.time.Duration;
import java.time.Duration;
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

public class autosuggest_dropdown {
	
	public static WebDriver  driver;
	public  static WebDriverWait wait;
	
	   public static void main(String[] args) throws Exception {
		   
		   

		/*	WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();*/
	    	
	    	WebDriverManager.edgedriver().setup();
			EdgeOptions options = new EdgeOptions();
			options.addArguments("Start-maximized");
			options.addArguments("--remote-allow-origins=*");
	//		options.setExperimentalOption("excludeSwitches", Collections.singleton("enable-automation"));
			WebDriver driver = new EdgeDriver(options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			driver.get("https://www.google.com/");
			
			driver.findElement(By.name("q")).sendKeys("selenium");
			Thread.sleep(5000);
	        List<WebElement> lists= driver.findElements(By.xpath("//li[@class='sbct']//div[@class='wM6W7d']//span")); 
		    System.out.println("size :"+ lists.size());
		    
		    for (WebElement webEle : lists) 
		    {
		    String e=webEle.getText();
		     if(e.contains(" webdriver"))
		     {
		    	 
		    	 Thread.sleep(2000);
		    	 webEle.click();
		    	 break;
		     }
			}
	    }

}
