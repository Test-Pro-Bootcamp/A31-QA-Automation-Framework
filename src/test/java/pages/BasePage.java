package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    //Attributes
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    //locator
    By successMsg = By.cssSelector("div.success.show");

    //constructor
    public BasePage (WebDriver givenDriver) {
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        PageFactory.initElements(driver,this);
    }

    //page methods
    public void waitClick(WebElement locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void doubleClick(WebElement locator) {
        waitClick(locator);
        actions.doubleClick(locator).perform();
    }

    public WebElement getSuccessMsg() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMsg));
    }
}
