package PracticeProject;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FileUpload {

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
		WebElement buttonclicks = driver.findElement(By.xpath("//h1[contains(text(),'FILE UPLOAD')]"));
		buttonclicks.click();
		Actions Builder = new Actions(driver);

		Set<String> allWindows = driver.getWindowHandles();
		System.out.println(allWindows);
		Iterator<String> itr = allWindows.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next();
			if (!parentwindow.equalsIgnoreCase(childwindow)) {
				driver.switchTo().window(childwindow);

				WebElement upload = driver.findElement(By.xpath("//input[@id='myFile']"));

				upload.sendKeys("C:\\Users\\91630\\Pictures\\Screenshots\\Screenshot 2024-02-15 101719.png");
				Thread.sleep(3000);

				WebElement submit = driver.findElement(By.xpath("//input[@id='submit-button']"));
				Builder.click(submit).perform();
				System.out.println("File Upload Successfully");
				Thread.sleep(500);

				Alert alt1 = driver.switchTo().alert();
				alt1.accept();
				Thread.sleep(500);

			}

		}
	}
}
