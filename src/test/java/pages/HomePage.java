package pages;

import java.util.Set;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.CommonUtils;

public class HomePage{
	public WebDriver driver;
	CommonUtils commonUtils=new CommonUtils(driver);
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	Logger log = Logger.getLogger(HomePage.class);
	
	By searchBar = By.cssSelector("#gh-ac");
	By searchCategory = By.cssSelector("#gh-cat");
	By addFirstBook=By.cssSelector(".s-item .s-item__title");
	By selectFirstBook=By.xpath("//ul[contains(@class, 'srp-results')]//li[contains(@class, 's-item')][not(preceding-sibling::li[contains(@class, 's-item')])]//a[contains(@class, 's-item__link')]");
	By addToCart=By.xpath("//*[text()='Add to cart']");
	By cartItem=By.xpath("//*[@class='gh-cart__icon']/span");
public HomePage() {
	PageFactory.initElements(driver, HomePage.class);
}
	public void userEntersStringInSearchBar(String bookName) {
		log.info("Searching for book");
		WebElement ele=driver.findElement(searchBar);
		commonUtils.enterText(ele, bookName);
		ele.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
	}
	
	public void clickOnFirstBook() {
		log.info("Clicking on first web element");
		WebElement firstElement=driver.findElement(selectFirstBook);
		commonUtils.clickElement(firstElement);
	}
	
	public void addTocart() {
		log.info("switching to window");
		String originalTab = driver.getWindowHandle();
        Set<String> allTabs = driver.getWindowHandles();
        for (String tab : allTabs) {
            if (!tab.equals(originalTab)) {
                driver.switchTo().window(tab);
                break;
            }
        }
		WebElement cartButton=driver.findElement(addToCart);
		log.info("Adding book to cart");
		commonUtils.clickElement(cartButton);
	}
	
	public String validateCartItemCount() {
		log.info("Verifying cart count");
		WebElement count=driver.findElement(cartItem);
		return count.getText();
	}
}


