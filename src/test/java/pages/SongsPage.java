package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;


public class SongsPage extends BasePage {


    private By allSongTabLocator = By.cssSelector("a.songs");
    private By selectFirstSonglocator = By.xpath("//*[@id='songsWrapper']//div[1]/table/tr[1]/td[2]");
    private By soundBar = By.xpath("//div[@data-testid='sound-bar-play']");
    private By selectFirstSongField = By.xpath("//*[@id='songsWrapper']//div[1]/table/tr[1]/td[2]");
    private By addSelectedSong = By.cssSelector("button.btn-add-to");
    private By selectCreatedPlaylist = By.xpath("//*[@id='songsWrapper']/header/div[3]/div/section[1]/ul/li[5]");
    private By songAddedMessageLocator = By.cssSelector("div.alertify-logs.top.right");


    public SongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }


    //Locate All Songs
    public void clickAllSongsTab() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(allSongTabLocator)).click();
    }


    // Locate first song from All Songs List,double click and play
    public void selectAndPlaySong() {
        Actions actions = new Actions(driver);
        WebElement selectFirstSongField = wait.until(ExpectedConditions.elementToBeClickable(selectFirstSonglocator));
        actions.doubleClick(selectFirstSongField).build().perform();
    }


    //Validate song is playing
    public void isSongPlaying() {
        WebElement soundBarVar = wait.until(ExpectedConditions.visibilityOfElementLocated(soundBar));
        // WebElement soundbar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
        Assert.assertTrue(soundBarVar.isDisplayed());
    }


    // Locate first song from All Songs List
    public void selectFirstSongFromAllSongs() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectFirstSongField)).click();
    }


    //locate AddTo button and click on it
    public void addToButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addSelectedSong)).click();
    }


    // Select Test Playlist
    public void selectAllReadyCreatedPlayList() {
        wait.until(ExpectedConditions.elementToBeClickable(selectCreatedPlaylist)).click();
    }


    // Validating Song added message
    public boolean isSongAddedMessageDisplayed() {
        WebElement songAddedMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(songAddedMessageLocator));
        return songAddedMessage.isDisplayed();
    }
}