package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage extends BasePage{

    private By userAvatarIcon = By.cssSelector("img.avatar");

    public HomePage(WebDriver givenDriver){
        super(givenDriver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public WebElement getUserAvatar(){
        return findElement(userAvatarIcon);
    }
}