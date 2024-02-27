package Axis.BSGSolutions;



	import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.edge.EdgeDriver;

	public class ScreenShot {
		public static WebDriver driver;
		   public static void main(String[] args) {
			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\91630\\Downloads\\edgedriver_win64\\msedgedriver.exe");

			driver = new EdgeDriver();
			driver.get("https://www.makemytrip.com/");
			
			driver.manage().window().maximize();
			File f= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(f, new File(""));
            System.out.println("Screenshot is Captured");
		}

	}
	
	