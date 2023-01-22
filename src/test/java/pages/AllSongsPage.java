package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllSongsPage extends BasePage {

    public AllSongsPage(WebDriver getDriver) {
        super(getDriver);
    }

    //WebElements
    @FindBy(css = "[href='#!/songs']")
    private WebElement allSongs;
    @FindBy(css = "button[class='btn-add-to']")
    private WebElement addToButton;
    @FindBy(css = "img[alt='Sound bars']")
    private WebElement soundBarsIcon;

    //Add song to the playlist - Homework17
    public void addSongToThePlaylist(String songTitle, String playlistName) {
        allSongs();
        selectSong(songTitle);
        addTo();
        selectPlaylist(playlistName);
    }

    //Click All Songs tab
    public void allSongs() {
        allSongs.click();
        // click(allSongs); //using BasePage click(By locator) method
    }

    public void selectSong(String sTitle) {
        WebElement clickSong = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='songsWrapper']//table[@class='items']//td[contains(text(), '" + sTitle + "')]")));
        clickSong.click();
    }

    //Click AddTo button
    public void addTo() {
        addToButton.click();
        //click(addToButton); //using BasePage click(By locator) method
    }

    //Select the existing playlist
    public void selectPlaylist(String pName) {
        WebElement clickPlaylistName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@class='existing-playlists']//li[contains(text(), '" + pName + "')]")));
        clickPlaylistName.click();
    }

//    public void validateTheSongIsAdded(String songTitle, String playlistName) {
//        navigateToPlaylist(playlistName);
//        Assert.assertTrue(confirmSongIsAdded(songTitle));
//    }

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

    //Select a song and play - Homework18 - Play A Song
    public void playSelectedSong(String songTitle) {
//        Actions playDesiredSong = new Actions(driver);
        WebElement selectSong = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='songsWrapper']//table[@class='items']//td[contains(text(), '" + songTitle + "')]")));
        actions.doubleClick(selectSong).perform();
    }

    //Validate the song is playing
    public boolean validateSongIsPlaying() {
        return soundBarsIcon.isDisplayed();
    }
}
