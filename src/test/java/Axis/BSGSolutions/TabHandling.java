package Axis.BSGSolutions;

import java.util.Iterator;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TabHandling {
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\91630\\Documents\\NewChromeDriver\\chromedriver-win64\\chromedriver-win64/chromedriver.exe");

		   driver = new ChromeDriver();
		   driver.get("https://demoqa.com/browser-windows");
		   
		   driver.manage().window().maximize();
			// get the parent window handle
			String parentwindow = driver.getWindowHandle();
			System.out.println(parentwindow);
			Thread.sleep(500);
			JavascriptExecutor js = (JavascriptExecutor)driver;

			  // vertical down scroll (x and y coordinates)

			  js.executeScript("window.scrollBy(0 , 400)", "");
			WebElement tab = driver.findElement(By.cssSelector("#tabButton"));
			tab.click();
			Set<String> allWindows = driver.getWindowHandles();
			System.out.println(allWindows);
			Iterator<String>  itr = allWindows.iterator();
			while(itr.hasNext()) {
				String childwindow = itr.next();
				if (!parentwindow.equalsIgnoreCase(childwindow)) {
					driver.switchTo().window(childwindow);
				WebElement text = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
				String txt = text.getText();
				System.out.println(txt);
			}
				driver.switchTo().window(parentwindow);
			}


	}
}


