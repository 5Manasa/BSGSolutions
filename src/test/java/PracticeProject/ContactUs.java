package PracticeProject;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class ContactUs {
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
		WebElement contact = driver.findElement(By.xpath("//h1[contains(text(),'CONTACT US')]"));

		Actions Builder = new Actions(driver);
		Builder.click(contact).perform();

		Thread.sleep(500);

		Set<String> allWindows = driver.getWindowHandles();
		System.out.println(allWindows);
		Iterator<String> itr = allWindows.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next();
			if (!parentwindow.equalsIgnoreCase(childwindow)) {
				driver.switchTo().window(childwindow);
				Actions builder = new Actions(driver);
				 
				WebElement firstname = driver.findElement(By.xpath("//input[@name='first_name']"));
				org.openqa.selenium.interactions.Action seriesofact = builder.moveToElement(firstname).click().keyDown(firstname, Keys.INSERT)
				.sendKeys(firstname, "Manasa").build();
				seriesofact.perform();
				 
				WebElement lastname = driver.findElement(By.xpath("//input[@name='last_name']"));
				org.openqa.selenium.interactions.Action seriesofact1 = builder.moveToElement(lastname).click().keyDown(lastname, Keys.INSERT)
				.sendKeys(lastname, "Tungala").build();
				seriesofact1.perform();
				 
				WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
				org.openqa.selenium.interactions.Action seriesofact2 = builder.moveToElement(email).click().keyDown(email, Keys.INSERT)
				.sendKeys(email, "Manasa@gmail.com").build();
				seriesofact2.perform();

				WebElement comment = driver.findElement(By.xpath("//textarea[@name='message']"));
				org.openqa.selenium.interactions.Action seriesofact3 = builder.moveToElement(email).click().keyDown(email, Keys.INSERT)
				.sendKeys(comment, "Comment").build();
				seriesofact3.perform();

				WebElement submit = driver.findElement(
				By.xpath("//input[@type='submit']"));
				 
				submit.click();

				WebElement fname = driver.findElement(By.xpath("//h1[contains(text(),'Thank You for your Message!')]"));
				String text = fname.getText();
				 		String expectedTxt = "Thank You for your Message!";
				 		if(text.equals(expectedTxt)) {
				 			System.out.println("Thank You Message is displayed");
				 		} else {
				 			System.out.println("Thank You Message is not displayed");
				 		}
				 
				}
				}
				}
				}

