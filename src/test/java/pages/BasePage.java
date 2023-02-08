package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

      static WebDriver driver;
      static WebDriverWait wait;
      static Actions actions;

    public BasePage( WebDriver givenDriver) {
        this.driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
    }

    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    public void click(WebElement locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public WebElement checkElement(WebElement element)
    {
        return  wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void contextClick(By locator) {
        actions.contextClick(findElement(locator)).perform();
    }

    public void doubleClick (By locator) {
        actions.doubleClick(findElement(locator)).perform();
    }

}