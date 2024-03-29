package PracticeProject;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class iFrames {

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

		WebElement iframe = driver.findElement(By.xpath("//h1[contains(text(),'IFRAME')]"));
		iframe.click();

		Set<String> allWindows = driver.getWindowHandles();
		System.out.println(allWindows);
		Iterator<String> itr = allWindows.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next();
			if (!parentwindow.equalsIgnoreCase(childwindow)) {
				driver.switchTo().window(childwindow);

				js.executeScript("window.scrollBy(0 , 400)", "");

				WebElement newFrame = driver.findElement(By.xpath("//iframe[@id='frame']"));
				driver.switchTo().frame(newFrame);
				Thread.sleep(500);
				// driver.findElement(By.xpath("//*[@id='nav-title']")).click();
				driver.findElement(By.xpath("//*[@id='div-main-nav']/div/ul/li[3]/a")).click();

				// *[@id="nav-title"]

			}
		}
	}
}