package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class HomePage extends BasePage {

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    By userAvatarIcon = By.cssSelector("img.avatar");
    By plusIcon = By.cssSelector("i[class='fa fa-plus-circle create']");
    By newPlaylistButton = By.cssSelector("li[data-testid='playlist-context-menu-create-simple']");
    By playlistInputField = By.cssSelector("input[name='name']");
    By deleteButton = By.cssSelector("[class='del btn-delete-playlist']");
    By successMsg = By.cssSelector("div.success.show");

    public WebElement getUserAvatar() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(userAvatarIcon));
    }

    public boolean isDisplayed() {
        return true;
    }

    //Create a playlist
    public void createPlaylist(String playlistName) {
        clickPlusIcon();
        clickNewPlaylistButton();
        createAPlaylistName(playlistName);
    }

    public void clickPlusIcon() {
        WebElement clickPlusButtonElement = driver.findElement(plusIcon);
        clickPlusButtonElement.click();
    }

    public void clickNewPlaylistButton() {
        WebElement selectNewPlaylistButton = driver.findElement(newPlaylistButton);
        selectNewPlaylistButton.click();
    }

    public void createAPlaylistName(String playlistName) {
        WebElement newPlaylistField = driver.findElement(playlistInputField);
        newPlaylistField.sendKeys(playlistName);
        newPlaylistField.submit();
    }

    //Navigate and select a playlist
    public void selectDesiredPlaylist(String playlistName) {
        WebElement selectAPlaylistElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='playlists']//li[@class='playlist playlist']//a[contains(text(),'" + playlistName + "')]")));
        selectAPlaylistElement.click();
    }

    //Delete the selected playlist
    public void deleteDesiredPlaylist() {
        WebElement clickDeleteButton = driver.findElement(deleteButton);
        clickDeleteButton.click();
    }

    //Validate the playlist is deleted
    public boolean deletionMsg() {
        WebElement successfulDeleteMsg = driver.findElement(successMsg);
        return successfulDeleteMsg.isDisplayed();
    }

    public void choosePlaylist(String playlistName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']//ul//li//a[contains(text(), '" + playlistName + "')]"))).click();
    }

    public void doubleClickChoosePlaylist(String playlistName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']//ul//li//a[contains(text(), '" + playlistName + "')]")));
        WebElement playlistElement = driver.findElement(By.xpath("//section[@id='playlists']//ul//li//a[contains(text(), '" + playlistName + "')]"));
        actions.doubleClick(playlistElement).perform();
    }

    public void enterPlaylistName(String playlistName) {
        WebElement playlistInputFieldElement = driver.findElement(playlistInputField);
        playlistInputFieldElement.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        playlistInputFieldElement.sendKeys(playlistName);
        playlistInputFieldElement.sendKeys(Keys.ENTER);
    }

    public boolean getSuccessMsg() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMsg));
        WebElement playlistElement = driver.findElement(successMsg);
        return playlistElement.isDisplayed();
    }

}