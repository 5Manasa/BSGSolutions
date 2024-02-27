package Axis.BSGSolutions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

	public class MultiCheckBox {
		public static WebDriver driver;
		public static void main(String[] args) throws InterruptedException {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\91630\\Documents\\NewChromeDriver\\chromedriver-win64\\chromedriver-win64/chromedriver.exe");

			driver = new ChromeDriver();
			driver.get("https://demo.seleniumeasy.com/basic-checkbox-demo.html");
			
			driver.manage().window().maximize();
			
			
			List <WebElement> checkall =  driver.findElements(By.xpath("//input[@type='checkbox']"));
			
			Thread.sleep(500);
			
			for (WebElement wb :checkall) {
				wb.click();
			}
			
  }
}
