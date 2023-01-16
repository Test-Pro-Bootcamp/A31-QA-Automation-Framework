package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomePage extends BasePage {



    public HomePage(WebDriver givenDriver){
        super(givenDriver);
    }
    public static HomePage homePage = new HomePage(driver);
   //Code for Play a Song. Homework18Test
    public static  boolean isSongPlaying() {
        WebElement songIsPlaying = driver.findElement(By.cssSelector("[data-testid='sound-bar-play']"));
        return songIsPlaying.isDisplayed();
    }
    @Test(description = "Play a song")
    public static void playSong() {
        homePage.provideEmail("skymena75@gmail.com");
        homePage.providePassword("te$t#tudent");
        homePage.clickSubmitButton();
        driver.findElement(By.cssSelector("[data-testid='play-next-btn']")).click();
        driver.findElement(By.cssSelector("[data-testid='play-btn']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='play-next-btn']"))).click();
        Assert.assertTrue(isSongPlaying());
    }
    //Code for Moving a Song to a Playlist Homework17Test
    public boolean isNotificationPopUpPresent(){
        WebElement notificationText = driver.findElement(By.cssSelector("div.success.show"));
        return notificationText.isDisplayed();
    }
    //   public String getNotificationText(){
    //   WebElement notificationText = driver.findElement(By.cssSelector("div.success.show"));
    //  return notificationText.getText();
    // }

    @Test(description = "Move a Song to a Play List")
    public void addASong(){
        homePage.provideEmail("skymena75@gmail.com");
        homePage.providePassword("te$t#tudent");
        homePage.clickSubmitButton();
        String newSongAddedNotification = "Added one song into";
        searchSong("Pluto");
        viewAllSearchResults();
        selectFirstSongResult();
        clickAddToButton();
        choosePlaylist("Test Pro Playlist");
        // Assert.assertTrue(getNotificationText().contains(newSongAddedNotification));
        Assert.assertTrue(isNotificationPopUpPresent());
    }
    public void searchSong(String songTitleKeyword){
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div#searchForm input[type='search']"))).sendKeys(songTitleKeyword);
    }
    public void viewAllSearchResults(){
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.results section.songs h1 button"))).click();
    }
    public void selectFirstSongResult(){
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("section#songResultsWrapper tr.song-item td.title"))).click();
    }
    public void clickAddToButton(){
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn-add-to"))).click();
    }
    public void choosePlaylist(String playlistName){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='songResultsWrapper']//section/ul/li[contains(text(),'"+playlistName+"')]"))).click();
    }
   // Code for Deleting a Playlist Homework19Test
    @Test(description = "Delete an Empty PlayList")
    public void deleteEmptyPlaylist(){
        homePage.provideEmail("skymena75@gmail.com");
        homePage.providePassword("te$t#tudent");
        homePage.clickSubmitButton();
        openPlayList();
        deletePlayList();
        WebElement deletedPlaylistMessage = getDeletedPlaylistMessage();
        Assert.assertTrue(deletedPlaylistMessage.isDisplayed());
    }

    public void openPlayList(){
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(3)"))).click();
    }
    private void deletePlayList(){
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn-delete-playlist"))).click();
    }
    public WebElement getDeletedPlaylistMessage(){

        return driver.findElement(By.cssSelector("div.success.show"));
    }
//Code for renaming a Playlist. Homework21Test
String playlistnewname = "Jarrod Playlist";

    @Test
    public void renamePlaylist() {
        homePage.provideEmail("skymena75@gmail.com");
        homePage.providePassword("te$t#tudent");
        homePage.clickSubmitButton();
        contextClickSelectPlaylist();
        contextClickEdit();
        Assert.assertTrue(checkPlaylistRenamed().isDisplayed());
    }

    public void contextClickSelectPlaylist() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(3)"))).click();
        WebElement playListName = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        actions.contextClick(playListName).perform();
    }

    public void contextClickEdit() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[data-testid^='playlist-context-menu-edit'"))).click();
        WebElement editField = driver.findElement(By.cssSelector("input{name='name']"));
        editField.sendKeys(playlistnewname);
        editField.sendKeys(Keys.ENTER);
    }

    public WebElement checkPlaylistRenamed() {

        return driver.findElement(By.cssSelector("div.success.show"));
    }
}
