package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PlaylistPage extends BasePage {

    //locators
    @FindBy(xpath = "//*[@id=\"playlistWrapper\"]/div/div/div[@class='item-container']/table/tr/td[@class='title' and contains(text(),\"Waiting On A Train\")]")
    private WebElement waitingOnATrainSongPlaylist;

    @FindBy (css = "button.del.btn-delete-playlist")
    private WebElement deletePlaylistButton;

    public PlaylistPage (WebDriver givenDriver) {
        super(givenDriver);
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    public WebElement confirmXYZPlaylist () {
        return wait.until(ExpectedConditions.visibilityOf(waitingOnATrainSongPlaylist));
    }

    public void deletePlaylist () {
        wait.until(ExpectedConditions.visibilityOf(deletePlaylistButton));
        deletePlaylistButton.click();
    }

    public WebElement getDeletePlaylistButton () {
        return wait.until(ExpectedConditions.visibilityOf(deletePlaylistButton));
    }

}
