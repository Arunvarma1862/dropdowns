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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class auto_dropdown 
{
	
	public static WebDriver  driver;
	public  static WebDriverWait wait;
	
	public static void main(String[] args) throws InterruptedException 
{
	
	WebDriverManager.chromedriver().setup();
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	
	driver = new ChromeDriver(options);
	driver.manage().window().maximize();
  //  driver.get("http://127.0.0.1:3000/dropdowns/index.html");
	

	
	driver.get("https://www.twoplugs.com/");
	options.addArguments("disable-notifications");
	driver.findElement(By.xpath("//a[text()='Live Posting']")).click();
	
      WebElement serachBox=	driver.findElement(By.id("autocomplete"));
      serachBox.clear();
      serachBox.sendKeys("toronto");
      String text;
      
      do 
      {
    	  serachBox.sendKeys(Keys.ARROW_DOWN);
    	  Thread.sleep(2000);
    	  text=  serachBox.getAttribute("value");
    	  if(text.equals("Toronto, OH, USA"))
    	  {
    		  serachBox.sendKeys(Keys.ENTER);
    		  break;
    	  }
    	  
      }
      while(!text.isEmpty());
driver.quit();
}

}
