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

public class Jquery_dropdown {
	
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
		
		driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
	//	driver.findElement(By.id("ide")).click();
		
	//	selectdrop(driver,"Eclipse");
	//	selectdrop(driver,"Eclipse","Visual Studio");
		  selectdrop(driver,"all");

	}
	public static void selectdrop(WebDriver driver,String...value) {
		
		 List<WebElement> list= driver.findElements(By.xpath("//select[@id='ide']/option"));
		 
		 if(!value[0].equalsIgnoreCase("all"))
		 {
			for(WebElement item:list ) 
			{
				String text= item.getText();
				
				for(String val:value) 
				{
					if(text.equals(val))
					{
						item.click();
						break;
					}
				}
			}
		 }
		 else
		 {
			 for (WebElement item : list) 
			 {
				 item.click();
				 		
			}
		 }
	}

}
