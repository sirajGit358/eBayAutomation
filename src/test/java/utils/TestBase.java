package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {

	public WebDriver driver;

	public Properties getPropertyFile() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\global.peroperties");
		Properties prop = new Properties();
		prop.load(fis);
		return prop;
	}

	public WebDriver WebDriverManager() throws IOException {
		if (driver == null) {
			if (getPropertyFile().getProperty("browser").equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				driver = new ChromeDriver(options);
				
			}
			driver.manage().window().maximize();
			driver.get(getPropertyFile().getProperty("QAUrl"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		}
		return driver;
	}
}
