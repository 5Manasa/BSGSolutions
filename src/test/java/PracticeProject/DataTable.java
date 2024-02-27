package PracticeProject;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DataTable {

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

		WebElement DataTable = driver.findElement(By.xpath("//h1[contains(text(),'DATA, TABLES & BUTTON STATES')]"));
		DataTable.click();

		Set<String> allWindows = driver.getWindowHandles();
		System.out.println(allWindows);
		Iterator<String> itr = allWindows.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next();
			if (!parentwindow.equalsIgnoreCase(childwindow)) {
				driver.switchTo().window(childwindow);
				WebElement fname = driver.findElement(By.xpath("//table[@id='t01']/tbody/tr[4]/td[1]"));
				String text1 = fname.getText();
				WebElement lname = driver.findElement(By.xpath("//table[@id='t01']/tbody/tr[4]/td[2]"));
				String text2 = lname.getText();
				WebElement age = driver.findElement(By.xpath("//table[@id='t01']/tbody/tr[4]/td[3]"));
				String text3 = age.getText();

				WebElement firstname = driver.findElement(By.xpath("//input[@name='firstname']"));
				Actions builder = new Actions(driver);
				org.openqa.selenium.interactions.Action seriesofact = builder.moveToElement(firstname).click()
						.keyDown(firstname, Keys.INSERT).sendKeys(text1).build();
				seriesofact.perform();
				WebElement lastname = driver.findElement(By.xpath("//input[@name='lastname']"));
				Actions builder1 = new Actions(driver);
				org.openqa.selenium.interactions.Action seriesofact1 = builder1.moveToElement(lastname).click()
						.keyDown(lastname, Keys.INSERT).sendKeys(text2).build();
				seriesofact1.perform();

				WebElement InputTxt = driver.findElement(By.xpath("//body/div[1]/div[2]/div[1]/form[1]/textarea[1]"));
				Actions builder2 = new Actions(driver);
				org.openqa.selenium.interactions.Action seriesofact2 = builder2.moveToElement(InputTxt).click()
						.keyDown(InputTxt, Keys.INSERT).sendKeys(text3).build();
				seriesofact2.perform();

				List<WebElement> rowno2 = driver.findElements(By.xpath("//table[@id = 't01']/tbody/tr"));
				int rowcount2 = rowno2.size();
				System.out.println(rowcount2);

				WebElement fname2 = driver.findElement(By.xpath("//table[@id='t02']/tbody/tr[2]/td[1]"));
				String text4 = fname2.getText();
				System.out.println(text4);
				WebElement lname2 = driver.findElement(By.xpath("//table[@id='t02']/tbody/tr[2]/td[2]"));
				String text5 = lname2.getText();
				System.out.println(text5);
				WebElement age2 = driver.findElement(By.xpath("//table[@id='t02']/tbody/tr[2]/td[3]"));
				String text6 = age2.getText();
				System.out.println(text6);
			}
		}
	}
}
