package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    public static WebDriver driver;
    public static WebDriverWait wait;
    Actions action;
    public static FluentWait fluentWait;

    public BasePage (WebDriver givenDriver) {
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        action = new Actions(driver);
    }

    public void doubleClick (WebElement locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        action.doubleClick(locator).perform();
    }



}
