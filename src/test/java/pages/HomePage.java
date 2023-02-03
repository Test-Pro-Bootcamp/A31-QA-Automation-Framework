package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    By avatarIcon = By.cssSelector("img.avatar");

    public HomePage(WebDriver givenDriver){
      driver = givenDriver;
      wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    public WebElement getUserAvatar(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(avatarIcon));
    }
}
