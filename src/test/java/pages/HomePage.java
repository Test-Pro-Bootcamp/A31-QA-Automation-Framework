package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

    public void changePlaylistName(String playlistname) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='name']")));
        WebElement playlistInputField = driver.findElement(By.xpath("//input[@name='name']"));
        playlistInputField.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        playlistInputField.sendKeys(playlistname);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public void myPlaylist() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists > ul > li:nth-child(3) > a")));
        WebElement webElement = driver.findElement(By.cssSelector("#playlists > ul > li:nth-child(3) > a"));
        actions.doubleClick(webElement).perform();
    }
    public void doubleClickPlaylist() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#playlists > ul > li:nth-child(3) > a")));
        doubleClick(By.cssSelector("#playlists > ul > li:nth-child(3) > a"));
    }

    public boolean doesPlaylistExist(String playlistname) {
        WebElement playlistElement = driver.findElement(By.xpath("//a[text()='"+playlistname+"']"));
        return playlistElement.isDisplayed();
    }
}
