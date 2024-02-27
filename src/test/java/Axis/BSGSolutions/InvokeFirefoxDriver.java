package Axis.BSGSolutions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InvokeFirefoxDriver {


		public static WebDriver driver;
		
		public static void main(String[] args) {
					 WebDriver driver = new FirefoxDriver();
			  driver.get("https://www.selenium.dev/");

		}

	}
	
