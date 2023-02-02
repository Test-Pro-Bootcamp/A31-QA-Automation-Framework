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
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public BasePage(WebDriver givenDriver) {
        driver = givenDriver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void doubleClick(WebElement locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        actions.doubleClick(locator).build().perform();
    }

    public void waitClick(WebElement locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void rightClick(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        actions.contextClick(element).build().perform();
    }

    public WebElement checkElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public boolean checkURl(String URL) {
        return wait.until(ExpectedConditions.urlToBe(URL));
    }
}
