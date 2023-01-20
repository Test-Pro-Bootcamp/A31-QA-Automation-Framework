package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    By userAvatarIcon = By.cssSelector("img.avatar");

    public HomePage( WebDriver givenDriver) {
        super(givenDriver);
    }

    public WebElement getUserAvatar () {
        return findElement(userAvatarIcon);
    }

    public void allSongs(){
        WebElement allSongs = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#sidebar > section.music > ul > li:nth-child(3) > a")));
        allSongs.click();
    }

}
