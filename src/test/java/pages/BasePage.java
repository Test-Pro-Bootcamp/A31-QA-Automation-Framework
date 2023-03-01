package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public BasePage( WebDriver givenDriver) {
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
    }
    public void click(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).click();
    }
    public void click(WebElement locator) {
        wait.until(ExpectedConditions.visibilityOf(locator)).click();
    }
    public void sendKeys(By locator, String textToEnter) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(textToEnter);
    }
    public WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void contextClick(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        actions.contextClick(findElement(locator)).perform();
    }
    public void contextClick(WebElement locator) {
        wait.until(ExpectedConditions.visibilityOf(locator));
        actions.contextClick((locator)).perform();
    }
    public void doubleClick (By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        actions.doubleClick(findElement(locator)).perform();
    }
}