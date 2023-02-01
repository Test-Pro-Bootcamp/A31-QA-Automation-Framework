package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{
    public HomePage(WebDriver dvr) {
        super(dvr);
    }

    By userAvatarIcon = By.cssSelector("img.avatar");

    public WebElement getUserAvatar(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(userAvatarIcon));
    }
}
