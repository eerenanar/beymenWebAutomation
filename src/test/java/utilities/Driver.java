package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;



public class Driver {

	private Driver() {
		
	}

	private static WebDriver driver;

	public static WebDriver getDriver() {
		if (driver==null) {
			switch(System.getProperty("browser")) {
			case "chrome":
				ChromeOptions option = new ChromeOptions();
				option.addArguments("--window-size=1920,1080","--remote-allow-origins=*");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(option);
				break;
			case "safari":
				WebDriverManager.safaridriver().setup();
				driver=new SafariDriver();
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
				break;
//			case "opera":
//				WebDriverManager.operadriver().setup();
//				driver=new OperaDriver();
//				break;
			default:
				WebDriverManager.safaridriver().setup();
				driver=new SafariDriver();
			}
	}

		return driver;

}

	public static void closeDriver() {
		if (driver!=null) {
			driver.quit();
			driver=null;
		}
	}
}
