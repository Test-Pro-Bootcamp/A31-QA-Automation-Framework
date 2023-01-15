package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HomePage extends BasePage{

    //Locators
    By avatarIcon = By.cssSelector("img.avatar");
    By successMsg = By.cssSelector("div.success.show");
    By plusButton = By.cssSelector("[class='fa fa-plus-circle create']");
    By newPlaylistOption = By.cssSelector("li[data-testid='playlist-context-menu-create-simple']");
    By playlistInputField = By.cssSelector("input[name='name']");
    By allSongsButton = By.xpath("//a[contains(text(), 'All Songs')]");
    By playlist = By.cssSelector(".playlist:nth-child(3)");


    //Constructor
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Page methods
    public WebElement getUserAvatar() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(avatarIcon));
    }

    public boolean getSuccessMsg() {
        return waitVisible(successMsg);
    }

    public void createdCustomPlaylist(String playlistName) {
        click(plusButton);
        click(newPlaylistOption);

        WebElement inputPlaylistName = driver.findElement(playlistInputField);
        inputPlaylistName.sendKeys(playlistName);
        inputPlaylistName.submit();
    }

    public void clickAllSongs() {
        click(allSongsButton);
    }

    public void clickPlaylist() {
        click(playlist);
    }

    public void doubleClickPlaylist() {
        doubleClick(driver.findElement(playlist));
    }

    public void renamePlaylist(String newPlaylistName) {
        waitClick(playlistInputField);
        driver.findElement(playlistInputField).sendKeys(Keys.chord(Keys.COMMAND, "a", Keys.BACK_SPACE));
        driver.findElement(playlistInputField).sendKeys(newPlaylistName);
        driver.findElement(playlistInputField).sendKeys(Keys.ENTER);
    }
}
