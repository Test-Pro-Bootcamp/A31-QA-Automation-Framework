package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage{

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public BasePage(WebDriver givenDriver)
    {
        this.driver = givenDriver;
        wait = new WebDriverWait(givenDriver, Duration.ofSeconds(5));
        actions = new Actions(driver);
    }

    public void click(By locator)
    {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void rightClick(By locator)
    {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        actions.contextClick(element).build().perform();
    }

    public void doubleClick(By locator)
    {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        actions.doubleClick(element).build().perform();
    }

    public WebElement checkElement(By locator)
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public boolean checkURl(String URL)
    {
        return  wait.until(ExpectedConditions.urlToBe(URL));
    }
}
