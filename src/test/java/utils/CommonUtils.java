package utils;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtils extends TestBase{

	public CommonUtils(WebDriver driver) {
		this.driver = driver;
	}
	
	public void waitForPageToLoad() {
		JavascriptExecutor j = (JavascriptExecutor)driver;
		if (j.executeScript("return document.readyState").toString().equals("complete")){
		   System.out.println("Page has loaded");
		}
	}
	public void waitForElementToBeVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
    }

	public void clickElement(WebElement element) {
        element.click();
    }

	public void enterText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }
}
