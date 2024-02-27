package Axis.BSGSolutions;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class NavigationalCommands {
		public static WebDriver driver;
		public static void main(String[] args) throws InterruptedException {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\91630\\Documents\\NewChromeDriver\\chromedriver-win64\\chromedriver-win64/chromedriver.exe");

			driver = new ChromeDriver();
			driver.get("https://automationexercise.com/");
			
			driver.navigate().forward();
		    Thread.sleep(500);
			
			
			driver.navigate().back();
			Thread.sleep(500);
			
			driver.navigate().refresh();
			
			driver.close();
			
	}

}
