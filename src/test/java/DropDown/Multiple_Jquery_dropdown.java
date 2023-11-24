package DropDown;

import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;



import io.github.bonigarcia.wdm.WebDriverManager;

;

public class Multiple_Jquery_dropdown {
	
	public static WebDriver  driver;
	public  static WebDriverWait wait;
	
	
public static void main(String[] args) throws Exception{
		
	WebDriverManager.chromedriver().setup();
	ChromeOptions options= new ChromeOptions();
	options.addArguments("Start-maximized");
	options.addArguments("--remote-allow-origins=*");
	options.setExperimentalOption("excludeSwitches", Collections.singleton("enable-automatiom"));
 driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));
		
		driver.get("http://127.0.0.1:3000/dropdowns/Multiple.html");
	//	driver.findElement(By.id("ide")).click();
		
   // 	selectdrop(driver,"Kohil_18");
		//selectdrop(driver,"Sehwag_49","ArunBabu_88");
		  selectdrop(driver,"all");

	}
	public static void selectdrop(WebDriver driver,String...value) throws InterruptedException {
		
		 List<WebElement> list= driver.findElements(By.xpath("//select[@id='Team']/option"));
		 
		 if(!value[0].equalsIgnoreCase("all"))
		 {
			for(WebElement item:list ) 
			{
				String text= item.getText();
				
				for(String val:value) 
				{
					if(text.equals(val))
					{
						Thread.sleep(1000);
						item.click();
						Thread.sleep(1000);
						break;
					}
				}
			}
		 }
		 else
		 {
			 for (WebElement item : list) 
			 {
					Thread.sleep(1000);
				 item.click();
					Thread.sleep(1000);
				 		
			}
		 }
	}

}
