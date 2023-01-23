package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;



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
