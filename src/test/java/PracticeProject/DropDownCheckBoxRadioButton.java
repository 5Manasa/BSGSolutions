package PracticeProject;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownCheckBoxRadioButton {

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

		WebElement tab = driver
				.findElement(By.xpath("//h1[contains(text(),'DROPDOWN, CHECKBOXE(S) & RADIO BUTTON(S)')]"));
		tab.click();

		Set<String> allWindows = driver.getWindowHandles();
		System.out.println(allWindows);
		Iterator<String> itr = allWindows.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next();
			if (!parentwindow.equalsIgnoreCase(childwindow)) {
				driver.switchTo().window(childwindow);

				WebElement dropdown1 = driver.findElement(By.xpath("//select[@id='dropdowm-menu-1']"));
				Select seldrop1 = new Select(dropdown1);
				Thread.sleep(1000);
				seldrop1.selectByVisibleText("SQL");



				WebElement dropdown2 = driver.findElement(By.xpath("//select[@id='dropdowm-menu-2']"));
				Select seldrop2 = new Select(dropdown2);
				Thread.sleep(1000);
				seldrop2.selectByVisibleText("JUnit");

				WebElement dropdown3 = driver.findElement(By.xpath("//select[@id='dropdowm-menu-3']"));
				Select seldrop3 = new Select(dropdown3);
				Thread.sleep(1000);
				seldrop3.selectByVisibleText("CSS");

				List<WebElement> allcheck = driver.findElements(By.xpath("//input[@type='checkbox']"));
				Thread.sleep(500);
				for (WebElement wb : allcheck) {
				wb.click();
				}

				WebElement radiobtn1 = driver.findElement(By.xpath("//input[@name='color'][@value='blue']"));
				Thread.sleep(500);
				radiobtn1.click();

				WebElement radiobtn2 = driver.findElement(By.xpath("//input[@name='vegetable'][@value='pumpkin']"));
				Thread.sleep(500);
				radiobtn2.click();

				WebElement dropdown4 = driver.findElement(By.xpath("//select[@id='fruit-selects']"));
				Select seldrop4 = new Select(dropdown4);
				Thread.sleep(1000);
				seldrop4.selectByVisibleText("Pear");

				}
				}
				}
				}

