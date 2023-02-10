package pages;

import org.openqa.selenium.By;
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

    private By bysoundBar= By.xpath("//div[@data-testid='sound-bar-play']");

    @FindBy(css ="button.btn-add-to" )
    private WebElement addSelectedSong;
    @FindBy(xpath = "//*[@id='songsWrapper']/header/div[3]/div/section[1]/ul/li[5]")
    private WebElement selectCreatedPlaylist;
    @FindBy(css = "div.alertify-logs.top.right")
    private WebElement songAddedMessageLocator;
    private By bysongAddedMessageLocator= By.cssSelector("div.alertify-logs.top.right");
    public SongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    // Locate first song from All Songs List,double click and play
    public void selectAndPlaySong() {
        Actions actions = new Actions(driver);
        WebElement selectFirstSongField = wait.until(ExpectedConditions.elementToBeClickable(selectFirstSonglocator));
        actions.doubleClick(selectFirstSongField).build().perform();
    }

    // Locate first song from All Songs List
    public void selectFirstSongFromAllSongs() {
        wait.until(ExpectedConditions.elementToBeClickable(selectFirstSonglocator)).click();
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(bysongAddedMessageLocator));
        return songAddedMessageLocator.isDisplayed();
    }
    //Validate song is playing
    public boolean isSongPlaying() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(bysoundBar));
        return soundBar.isDisplayed();
    }
    public void chooseAllSongsList() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section.music a.songs"))).click();
    }
}
