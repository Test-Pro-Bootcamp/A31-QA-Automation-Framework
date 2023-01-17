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
    public static Actions action;
    public static FluentWait fluentWait;

    public BasePage (WebDriver givenDriver) {
        driver = givenDriver;
        driver.manage().timeouts(10);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        action = new Actions(driver);
    }

    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    public WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
