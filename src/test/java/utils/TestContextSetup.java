package utils;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import pages.PageObjectManager;


public class TestContextSetup {
	public WebDriver driver;
	public PageObjectManager pageObjectManager;
	public TestBase testBase;
	public CommonUtils genericUtils;
	public Properties prop;
	
	public TestContextSetup() throws IOException {
		testBase = new TestBase();
		pageObjectManager = new PageObjectManager(testBase.WebDriverManager());
		genericUtils = new CommonUtils(testBase.WebDriverManager());
		this.prop = testBase.getPropertyFile();
	}
}
