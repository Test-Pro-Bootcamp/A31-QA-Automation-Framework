package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllSongsPage extends BasePage {
    public AllSongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //WebElement
    @FindBy(css = "[href='#!/songs']")
    private WebElement allSongs;
    @FindBy(css = "button[class='btn-add-to']")
    private WebElement addToButton;
    @FindBy(css = "img[alt='Sound bars']")
    private WebElement soundBarsIcon;

    public void addSongToPlaylist(String sTitle, String pName) {
        allSongs.click();
        click(By.xpath("//section[@id='songsWrapper']//table[@class='items']//td[contains(text(), '" + sTitle + "')]"));
        waitClick(addToButton);
        addToButton.click();
        click(By.xpath("//section[@class='existing-playlists']//li[contains(text(), '" + pName + "')]"));
    }

    //Add song to the playlist
    public void addSongToThePlaylist(String songTitle, String playlistName) {
        allSongs();
        selectSong(songTitle);
        addTo();
        selectPlaylist(playlistName);
    }

    //Click All Songs tab
    public void allSongs() {
        allSongs.click();
    }

    public void selectSong(String sTitle) {
        WebElement clickSong = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='songsWrapper']//table[@class='items']//td[contains(text(), '" + sTitle + "')]")));
        clickSong.click();
    }

    //Click AddTo button
    public void addTo() {
        addToButton.click();
    }

    //Select the existing playlist
    public void selectPlaylist(String pName) {
        WebElement clickPlaylistName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@class='existing-playlists']//li[contains(text(), '" + pName + "')]")));
        clickPlaylistName.click();
    }

    //Navigate to the playlist
    public void navigateToPlaylist(String pName) {
        WebElement goToPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='playlists']//li[@class='playlist playlist']//a[contains(text(), '" + pName + "')]")));
        goToPlaylist.click();
    }

    //Confirm the song is added
    public boolean confirmSongIsAdded(String sTitle) {
        WebElement confirmSong = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='playlistWrapper']//td[contains(text(), '" + sTitle + "')]")));
        return confirmSong.isDisplayed();
    }

    //Select a song and play
    public void playSelectedSong(String songTitle) {
        WebElement selectSong = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='songsWrapper']//table[@class='items']//td[contains(text(), '" + songTitle + "')]")));
        actions.doubleClick(selectSong).perform();
    }

    //Validate the song is playing
    public boolean validateSongIsPlaying() {
        return soundBarsIcon.isDisplayed();
    }
}
