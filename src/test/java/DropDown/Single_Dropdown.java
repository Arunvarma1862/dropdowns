package DropDown;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Single_Dropdown {
	
	public static WebDriver  driver;
	public  static WebDriverWait wait;

	
	  public static void main(String[] args) throws InterruptedException 
      {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
		    driver = new ChromeDriver(options);
			driver.manage().window().maximize();
    	driver.get("http://127.0.0.1:3000/dropdowns/index.html");
    	wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//		driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
    	
String parentwindow=	driver.getWindowHandle();


wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hello"))).click();
		

    	
    Set<String>  windows=	driver.getWindowHandles();
    
    for (String string : windows)
    {
    	  if(!string.equals(parentwindow))
    	  {
    		  driver.switchTo().window(string);
		
		WebElement course=driver.findElement(By.id("Player"));
		Select courseElement= new Select(course);
		
		List<WebElement> courseoption = courseElement.getOptions();
		for(WebElement option : courseoption ) 
		{
			System.out.println(option.getText());
		}
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.id("Player"))).click().perform();	
		courseElement.selectByIndex(5);
		Thread.sleep(1000);	
		act.moveToElement(driver.findElement(By.id("Player"))).click().perform();	
		Thread.sleep(3000);	
		act.moveToElement(driver.findElement(By.id("Player"))).click().perform();
			
		courseElement.selectByValue("India");
		Thread.sleep(1000);
		act.moveToElement(driver.findElement(By.id("Player"))).click().perform();	
		
		Thread.sleep(3000);
		act.moveToElement(driver.findElement(By.id("Player"))).click().perform();	
		courseElement.selectByVisibleText("England");
		Thread.sleep(1000);
		act.moveToElement(driver.findElement(By.id("Player"))).click().perform();	
		Thread.sleep(2000);
		
		
	
	
		
		String visiblefirst = courseElement.getFirstSelectedOption().getText();
		System.out.println("visible element "+ visiblefirst);
		Thread.sleep(2000);
		driver.quit();
		
      
 
    	  }
	}
    	
}
}
	  