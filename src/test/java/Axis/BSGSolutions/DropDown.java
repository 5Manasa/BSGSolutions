package Axis.BSGSolutions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\91630\\Documents\\NewChromeDriver\\chromedriver-win64\\chromedriver-win64/chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("http://www.dummypoint.com/seleniumtemplate.html");
		 
		driver.manage().window().maximize();
 
		Thread.sleep(500);
 
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='dropdown']"));
		
		Select sel=new Select(dropdown);
		
		sel.selectByVisibleText("Option3");
		Thread.sleep(500);
		sel.selectByValue("OptionFive");
		Thread.sleep(500);
		sel.selectByIndex(1);
		

	}

}
