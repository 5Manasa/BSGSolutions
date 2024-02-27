package Axis.BSGSolutions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class InvokeEdgeDriver {
	public static WebDriver driver;
	   public static void main(String[] args) {
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\91630\\Downloads\\edgedriver_win64\\msedgedriver.exe");

		driver = new EdgeDriver();
		driver.get("https://www.selenium.dev/"); 

	}

}
