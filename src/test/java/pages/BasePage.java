package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;
    Actions acts;

    public BasePage( WebDriver givenDriver) {
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        acts = new Actions(driver);

        PageFactory.initElements(driver, this);
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

    public void contextClick(By locator) {
        acts.contextClick(findElement(locator)).perform();
    }

    public void doubleClick (By locator) {
        acts.doubleClick(findElement(locator)).perform();
    }

}