package pages;

import com.beust.ah.A;
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
    Actions actions;

    public BasePage( WebDriver givenDriver) {
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);     //we added this one

        PageFactory.initElements(driver,this);
    }

    public void click(WebElement locator) {
        wait.until(ExpectedConditions.visibilityOf(locator));
    }

    public WebElement findElement(WebElement locator) {
        return wait.until(ExpectedConditions.visibilityOf(locator));
    }

    public void contextClick(WebElement locator) {
        actions.contextClick((locator)).perform();
    }

    public void doubleClick (WebElement locator) {
        actions.doubleClick((locator)).perform();
    }

}