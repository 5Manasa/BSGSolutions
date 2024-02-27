package Axis.BSGSolutions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HorizontalScroll {
		public static WebDriver driver;
		public static void main(String[] args) throws InterruptedException {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\91630\\Documents\\NewChromeDriver\\chromedriver-win64\\chromedriver-win64/chromedriver.exe");

			driver = new ChromeDriver();
			driver.get("https://www.facebook.com/login/");
			
			Thread.sleep(500);
			
			JavascriptExecutor js=(JavascriptExecutor)driver;
			
			js.executeScript("windows.scrollBy(0,600)","");
			js.executeScript("windows.scrollBy(0,-500)","");
			js.executeScript("windows.scrollBy(500,0)","");
			js.executeScript("windows.scrollBy(-200,0)","");
	      
			WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'Meta © 2024')]"));
			js.executeScript("arguments[0].scrollIntoView(true);", ele);
		}
		

}
