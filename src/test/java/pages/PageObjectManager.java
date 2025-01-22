package pages;

import org.openqa.selenium.WebDriver;

import utils.CommonUtils;


public class PageObjectManager {
	public HomePage homePage;
	public WebDriver driver;
	public CommonUtils commonUtils;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public HomePage getLandingPage() {
		homePage = new HomePage(driver);
		return homePage;
	}

	public CommonUtils getCommonUtils() {
		commonUtils = new CommonUtils(driver);
		return commonUtils;
	}
}
