package PracticeProject;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\91630\\Documents\\NewChromeDriver\\chromedriver-win64\\chromedriver-win64/chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://webdriveruniversity.com/");

		driver.manage().window().maximize();
		// get the parent window handle
		String parentwindow = driver.getWindowHandle();
		System.out.println(parentwindow);
		Thread.sleep(500);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// vertical down scroll (x and y coordinates)

		js.executeScript("window.scrollBy(0 , 400)", "");

		WebElement DatePicker = driver.findElement(By.xpath("//h1[contains(text(),'DATEPICKER')]"));
		DatePicker.click();

		Set<String> allWindows = driver.getWindowHandles();
		System.out.println(allWindows);
		Iterator<String> itr = allWindows.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next();
			if (!parentwindow.equalsIgnoreCase(childwindow)) {
				driver.switchTo().window(childwindow);

				WebElement Calender = driver.findElement(By.xpath("//body/div[1]/div[2]/div[1]/div[1]/span[1]/i[1]"));
				Calender.click();

				WebElement Change = driver
						.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/table[1]/thead[1]/tr[1]/th[2]"));
				Change.click();

				WebElement Month = driver.findElement(By.xpath("//span[contains(text(),'Jul')]"));
				Month.click();

				WebElement Date = driver.findElement(By.xpath("//td[contains(text(),'19')]"));

				Date.click();

			}
		}
	}

}
