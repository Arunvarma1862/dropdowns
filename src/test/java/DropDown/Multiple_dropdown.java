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

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Multiple_dropdown {

	public static WebDriver driver;
	public static WebDriverWait wait;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("http://127.0.0.1:3000/dropdowns/index.html");
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		String parentwindow = driver.getWindowHandle();

		driver.findElement(By.xpath("//li[text()='Multiple dropdown']")).click();

		Set<String> windows = driver.getWindowHandles();

		for (String string : windows) {
			if (!string.equals(parentwindow)) {
				driver.switchTo().window(string);

				WebElement ideElement = driver.findElement(By.id("Team"));
				Select ideoptions = new Select(ideElement);

				List<WebElement> ide = ideoptions.getOptions();
				for (WebElement ides : ide) {
					System.out.println(ides.getText());
				}

				ideoptions.selectByIndex(0);
				Thread.sleep(2000);

				ideoptions.selectByValue("Sehwag");
				Thread.sleep(2000);

				ideoptions.selectByVisibleText("ArunBabu_88");
				Thread.sleep(2000);

				ideoptions.selectByVisibleText("Bumrah_96");
				Thread.sleep(2000);

//    			ideoptions.deselectByVisibleText("Bumrah_96");
//    			Thread.sleep(2000);

				List<WebElement> all = ideoptions.getAllSelectedOptions();
				for (WebElement alls : all) {
					System.out.println("visible selected -" + alls.getText());

					if (alls.getText().equals("NetBeans")) {
						alls.click();
						break;
					}
				}

				Thread.sleep(2000);
				driver.quit();
			}
		}

	}

}
