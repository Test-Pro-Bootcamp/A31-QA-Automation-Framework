package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePage {

    WebDriver driver;
    WebDriver wait;
    Actions actions;

    public BasePage(WebDriver givenDriver) { super();}

    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)); 
    }
    
    public WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
