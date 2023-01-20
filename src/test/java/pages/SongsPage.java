package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class SongsPage extends BasePage {
    @FindBy(xpath ="//*[@id='songsWrapper']//div[1]/table/tr[1]/td[2]")
    private WebElement selectFirstSonglocator;
    @FindBy(xpath = "//div[@data-testid='sound-bar-play']" )
    private WebElement soundBar;
    @FindBy(xpath ="//*[@id='songsWrapper']//div[1]/table/tr[1]/td[2]" )
    private WebElement selectFirstSongField;
    @FindBy(css ="button.btn-add-to" )
    private WebElement addSelectedSong;
    @FindBy(xpath = "//*[@id='songsWrapper']/header/div[3]/div/section[1]/ul/li[5]")
    private WebElement selectCreatedPlaylist;
    @FindBy(css = "div.alertify-logs.top.right")
    private WebElement songAddedMessageLocator;
    public SongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    // Locate first song from All Songs List,double click and play
    public void selectAndPlaySong() {
        Actions actions = new Actions(driver);
        WebElement selectFirstSongField = wait.until(ExpectedConditions.elementToBeClickable(selectFirstSonglocator));
        actions.doubleClick(selectFirstSongField).build().perform();
    }

    //Validate song is playing
    public boolean isSongPlaying() {
        return soundBar.isDisplayed();
    }

    // Locate first song from All Songs List
    public void selectFirstSongFromAllSongs() {
        wait.until(ExpectedConditions.elementToBeClickable(selectFirstSongField)).click();
    }

    //locate AddTo button and click on it
    public void addToButton() {
        wait.until(ExpectedConditions.elementToBeClickable(addSelectedSong)).click();
    }

    // Select Test Playlist
    public void selectAllReadyCreatedPlayList() {
        wait.until(ExpectedConditions.elementToBeClickable(selectCreatedPlaylist)).click();
    }

    // Validating Song added message
    public boolean isSongAddedMessageDisplayed() {
        return songAddedMessageLocator.isDisplayed();
    }
}

