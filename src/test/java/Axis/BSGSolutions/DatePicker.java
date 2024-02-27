package Axis.BSGSolutions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class DatePicker {
		public static WebDriver driver;
		public static void main(String[] args) throws InterruptedException {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\91630\\Documents\\NewChromeDriver\\chromedriver-win64\\chromedriver-win64/chromedriver.exe");

			driver = new ChromeDriver();
			driver.get("https://www.makemytrip.com/");
			
			driver.manage().window().maximize();
			
			
			WebElement date =  driver.findElement(By.xpath("//span[contains(text(),'Departure')]"));
			
			Thread.sleep(1000);
			date.click();

		   WebElement newdate =  driver.findElement(By.xpath("//div[@class='DayPicker-Day'][@aria-label=\"Tue Feb 27 2024\"]"));
	       Thread.sleep(1000);
		   newdate.click();
			
			
		}
}
