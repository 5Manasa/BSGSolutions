package Axis.BSGSolutions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserCommands {
	public static WebDriver driver;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\91630\\Documents\\NewChromeDriver\\chromedriver-win64\\chromedriver-win64/chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://automationexercise.com/");
		
		String Title=driver.getTitle();
		System.out.println(Title);
		
		String Url=driver.getCurrentUrl();
		System.out.println(Url);
		
		String PageSource=driver.getPageSource();
		System.out.println(PageSource);
	}
	
}

