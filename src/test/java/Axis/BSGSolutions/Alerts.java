package Axis.BSGSolutions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\91630\\Documents\\NewChromeDriver\\chromedriver-win64\\chromedriver-win64/chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/practice-pop-ups-selenium-webdriver"); 

		WebElement infoalert =  driver.findElement(By.xpath("//input[@name='Alert']"));
		
		Thread.sleep(1000);
		infoalert.click();
		
		Alert alt1= driver.switchTo().alert();
		
		alt1.accept();
		
        WebElement confalert =  driver.findElement(By.xpath("//input[@name='Confirmation')]"));
		
		Thread.sleep(1000);
		confalert.click();
		
		Alert alt2= driver.switchTo().alert();
		
		alt2.dismiss();
		
        WebElement promalert =  driver.findElement(By.xpath("//input[@name='Prompt')]"));
		
		Thread.sleep(500);
		promalert.click();
		
		Alert alt3= driver.switchTo().alert();
		
		alt3.accept();
		
		
		
	}

}
