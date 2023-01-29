package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePageTest {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

public BasePageTest(WebDriver givenDriver){
    driver = givenDriver;
    wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    actions = new Actions(driver);
    PageFactory.initElements(driver, this);
}
public void doubleClick(WebElement locator){
wait.until(ExpectedConditions.elementToBeClickable(locator));
actions.doubleClick().perform();
}
}




