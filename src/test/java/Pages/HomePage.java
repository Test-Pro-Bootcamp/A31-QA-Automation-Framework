package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    By userAvatarIcon = By.cssSelector("img.avatar");

    public HomePage (WebDriver givenDriver){
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public WebElement getUserAvatar (){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(userAvatarIcon));
    }

}
