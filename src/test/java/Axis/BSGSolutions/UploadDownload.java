package Axis.BSGSolutions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadDownload {

		public static WebDriver driver;
		public static void main(String[] args) throws InterruptedException {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\91630\\Documents\\NewChromeDriver\\chromedriver-win64\\chromedriver-win64/chromedriver.exe");

			driver = new ChromeDriver();
			driver.get("https://chercher.tech/practice/practice-pop-ups-selenium-webdriver");
			
			driver.manage().window().maximize();
			
			
			WebElement upload =  driver.findElement(By.xpath("//input[@name='upload')]"));
			
			Thread.sleep(500);
			upload.sendKeys("file:///C:/Users/91630/Documents/18211A02B2.pdf");
			
			WebElement download =  driver.findElement(By.xpath("//input[@name='download')]"));
			
			Thread.sleep(500);
			download.click();

   }
} 
