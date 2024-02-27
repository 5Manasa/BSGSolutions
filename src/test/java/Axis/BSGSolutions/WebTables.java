package Axis.BSGSolutions;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebTables {

	public static WebDriver driver;
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\91630\\Documents\\NewChromeDriver\\chromedriver-win64\\chromedriver-win64/chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/tables");
		 
		driver.manage().window().maximize();
		
		// implicit wait will wait for all the elements in the script to load before it could throw 
				//element not found exception

				driver.manage().timeouts().implicitlyWait(20 , TimeUnit.MILLISECONDS);
 
		
	    List<WebElement> rowno= driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
	    int rowcount=rowno.size();
	    System.out.println(rowcount);
	    
	    List<WebElement> colno= driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td"));
	    int colcount=colno.size();
	    System.out.println(colcount);
	    
	 // explicit wait is used to wait for a particular element based on the expected condition
	 		// explicit wait - to wait for the compose button to be click-able
	 		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	  
	 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id = 'table1']/tbody/tr[4]/td[3]")));
	    
	    WebElement celldata= driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[4]/td[3]"));
	    String text=celldata.getText();
        System.out.println(text);
 		
 		String expectedTxt = "tconway@earthlink,net";
 		if(text.equals(expectedTxt)) {
 			System.out.println("The cell data is correct");
 		} else {
 			System.out.println("The cell data is correct");
	    
 		}

    }
}