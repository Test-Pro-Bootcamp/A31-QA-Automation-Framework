package Pages;
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

    Actions action;
    public BasePage(WebDriver givenDriver){
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public WebElement findElement(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void doubleClick(By locator){
        action.doubleClick(findElement(locator)).perform();
    }

    public void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void contextClick(By locator){
        action.contextClick(findElement(locator)).perform();
    }
}