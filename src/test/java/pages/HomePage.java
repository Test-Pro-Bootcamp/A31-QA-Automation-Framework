package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    By userAvatarIcon = By.cssSelector("img.avatar");

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }


    public WebElement getUserAvatar() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(userAvatarIcon));
    }





    //Create a playlist
    public void createPlaylist() throws InterruptedException {
        String playlistName = "HW19";
        WebElement clickPlusButton = driver.findElement(By.cssSelector("i[class='fa fa-plus-circle create']"));
        clickPlusButton.click();
        Thread.sleep(2000);

        WebElement clickNewPlaylistButton = driver.findElement(By.cssSelector("li[data-testid='playlist-context-menu-create-simple']"));
        clickNewPlaylistButton.click();
        Thread.sleep(2000);

        WebElement newPlaylistField = driver.findElement(By.cssSelector("input[name='name']"));
        newPlaylistField.sendKeys(playlistName);
        newPlaylistField.submit();
        Thread.sleep(2000);
    }

    //Navigate and select a playlist
    public void selectDesiredPlaylist() throws InterruptedException {
        String playlistName = "HW19";
        WebElement selectAPlaylist = driver.findElement(By.xpath("//section[@id='playlists']//li[@class='playlist playlist']//a[contains(text(),'" + playlistName + "')]"));
        selectAPlaylist.click();
        Thread.sleep(2000);
    }

    //Delete the selected playlist
    public void deleteDesiredPlaylist() throws InterruptedException {
        WebElement clickDeleteButton = driver.findElement(By.cssSelector("[class='del btn-delete-playlist']"));
        clickDeleteButton.click();
        Thread.sleep(2000);
    }

    //Validate the playlist is deleted
    public void deletionMsg() throws InterruptedException {
        WebElement successfulDeleteMsg = driver.findElement(By.cssSelector("[class='success show']"));
        Assert.assertTrue(successfulDeleteMsg.isDisplayed());
    }


}