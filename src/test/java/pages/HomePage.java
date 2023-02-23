package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class HomePage extends BasePage {
    By userAvatarIcon = By.cssSelector("img.avatar");
    By allSongs = By.xpath("//a[contains(text(),'All Songs')]");
    By newPlaylistIcon = By.xpath("//i[@class='fa fa-plus-circle create']");
    By newPlaylistOption = By.xpath("//li[contains(text(), 'New Playlist')]");
    By newPlaylistField = By.xpath("//input[@name='name']");

    By myFirstPlaylist = By.cssSelector(".playlist:nth-child(3)");
    By deletePlaylistOption = By.xpath("//li[text()='Delete']");
    By notificationPopUp = By.xpath("//div[@class='success show']");

    public HomePage( WebDriver givenDriver) {

        super(givenDriver);
    }

    public void clickAllSongs(){
        click(allSongs);
    }
    public void clickNewPlaylistIcon(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(newPlaylistIcon));
        click(newPlaylistIcon);
    }
    public void clickNewPlaylistOption(){

        click(newPlaylistOption);
    }
    public void enterNewPlaylistName(String playlistName){
        sendKeys(newPlaylistField,Keys.chord(Keys.CONTROL,"a",Keys.BACK_SPACE));
        sendKeys(newPlaylistField,playlistName);
        driver.findElement(newPlaylistField).sendKeys(Keys.ENTER);
    }
    public HomePage doubleClickFirstUserPlaylist() {
        doubleClick(myFirstPlaylist);
        return this;
    }
    public HomePage contextClickFirstUserPlaylist() {
        contextClick(myFirstPlaylist);
        return this;
    }
    public void chooseDeletePlaylistOption(){
        click(deletePlaylistOption);
    }
    public WebElement getUserAvatar () {
        return findElement(userAvatarIcon);
    }
    public String getPopUpNotificationText(){
        return findElement(notificationPopUp).getText();
    }






}
