package DropDown;

import java.time.Duration;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Bootstrap_dropdown {
	public static WebDriver  driver;
	public  static WebDriverWait wait;

	public static void main(String[] args) throws InterruptedException {
		

	WebDriverManager.chromedriver().setup();
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	 options.addArguments("Start-maximized");
	  options.setExperimentalOption("excludeSwitches",  new String[] {"enable-automation"});
	//options.setExperimentalOption("excludeSwitches",  Arrays.asList("disable-popup-blocking"));
	options.addArguments("disable-notifications");
	driver = new ChromeDriver(options);
	driver.manage().window().maximize();
driver.get("http://127.0.0.1:3000/dropdowns/index.html");
	
   // driver.get("https://www.hdfcbank.com/");
    wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    
   String parentwindow= driver.getWindowHandle();
   Thread.sleep(2000);
   
   Actions act = new Actions(driver);
   act.moveToElement(driver.findElement(By.xpath("//li[text()='Bootstrap download']")));
   
   act
  .moveToElement(driver.findElement(By.xpath("//h1[text()='Types of dropdowns:-']"))).click().perform();
   Thread.sleep(3000);
 act.moveToElement(driver.findElement(By.xpath("//li[text()='Bootstrap download']")))
 .click()
  .perform();

   //   driver.findElement(By.xpath("//li[text()='Bootstrap download']")).click();
      
      Thread.sleep(2000);
      
  Set<String> window=    driver.getWindowHandles();
      
   for (String string : window) {
	   
	   if(!string.equals(parentwindow)) {
		   
		   
		   driver.switchTo().window(string);

		// product type

		     driver.findElement(By.xpath("//div[@class='drp1']//div[@class='dropdown']")).click();
		     List<WebElement> elements= driver.findElements(By.xpath("//ul[@class='dropdown1 dropdown-menu']/li"));
		     System.out.println(elements.size());
		     selectDrop(elements,"Cards");

		  //product
		 
		     driver.findElement(By.xpath("//div[@class='drp2']//div[@class='dropdown']")).click();
		     List<WebElement>ele= driver.findElements(By.xpath("//ul[@class='dropdown2 dropdown-menu']/li"));
		     System.out.println(ele.size());
		     selectDrop(ele,"Debit cards");
		  
		    //  driver.quit();
	   }
	
}

  
}
           public static void selectDrop(List<WebElement> eles , String value) {
	
	           for (WebElement Element : eles)
	            {
		           if(Element.getText().equalsIgnoreCase(value)) {
			        Element.click();
			       break;
			  
		       }
		 
}
}
}