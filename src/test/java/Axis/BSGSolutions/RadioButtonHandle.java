package Axis.BSGSolutions;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

	public class RadioButtonHandle {
		public static WebDriver driver;
		public static void main(String[] args) throws InterruptedException {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\91630\\Documents\\NewChromeDriver\\chromedriver-win64\\chromedriver-win64/chromedriver.exe");

			driver = new ChromeDriver();
			driver.get("https://demo.seleniumeasy.com/basic-radiobutton-demo.html");
			
			driver.manage().window().maximize();
		
			WebElement radio2= driver.findElement(By.xpath("//input[@type='radio'])[2]"));
			if(radio2.isSelected()) {
				radio2.click();
				}
			WebElement radio1= driver.findElement(By.xpath("//input[@type='radio'])[1]"));
			Thread.sleep(500);
			if(radio1.isDisplayed()) {
				radio1.click();
				}
		}
} 