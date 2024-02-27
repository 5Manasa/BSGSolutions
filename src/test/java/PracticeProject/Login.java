package PracticeProject;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Login {

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

		WebElement login = driver.findElement(By.xpath("//a[@id='login-portal']"));
		login.click();

		Set<String> allWindows = driver.getWindowHandles();
		System.out.println(allWindows);
		Iterator<String> itr = allWindows.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next();
			if (!parentwindow.equalsIgnoreCase(childwindow)) {
				driver.switchTo().window(childwindow);
				WebElement username = driver.findElement(By.xpath("//input[@id='text']"));

				Actions builder = new Actions(driver);

				org.openqa.selenium.interactions.Action seriesofact = builder.moveToElement(username).click()
						.keyDown(username, Keys.INSERT).sendKeys(username, "webdriver").build();
				seriesofact.perform();

				WebElement password = driver.findElement(By.xpath("//input[@id='password']"));

				org.openqa.selenium.interactions.Action seriesofact1 = builder.moveToElement(password).click()
						.keyDown(password, Keys.INSERT).sendKeys(password, "webdriver123").build();
				seriesofact1.perform();
				Thread.sleep(1000);
				WebElement loginbutton = driver.findElement(By.xpath("//button[@id='login-button']"));

				loginbutton.click();
				Thread.sleep(3000);

				Alert alt = driver.switchTo().alert();

				alt.accept();

			}
		}
	}
}
