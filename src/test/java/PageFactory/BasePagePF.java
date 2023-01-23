package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePagePF{

    static WebDriver driver;
    static WebDriverWait wait;
    static Actions actions;

    public BasePagePF(WebDriver givenDriver){
        driver = givenDriver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }
    public void contextClick(By locator) {
        actions.contextClick(findElement(locator)).perform();
    }

    public WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void doubleClick (By locator) {
        actions.doubleClick(findElement(locator)).perform();
    }
}
