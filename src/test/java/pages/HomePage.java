package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class HomePage extends BasePage {

    By userAvatarIcon = By.cssSelector("img.avatar");
    By plusIcon = By.cssSelector("i[class='fa fa-plus-circle create']");
    By newPlaylistButton = By.cssSelector("li[data-testid='playlist-context-menu-create-simple']");
    By playlistInputField = By.cssSelector("input[name='name']");
    By deleteButton = By.className("[class='del btn-delete-playlist']");
    By deleteSuccessMsg = By.cssSelector("[class='success show']");

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }


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
    public void deletionMsg() {
        WebElement successfulDeleteMsg = driver.findElement(deleteSuccessMsg);
        Assert.assertTrue(successfulDeleteMsg.isDisplayed());
    }

    public void choosePlaylist(String playlistName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']//ul//li//a[contains(text(), '" + playlistName + "')]"))).click();
    }

    public void doubleClickChoosePlaylist(String playlistName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']//ul//li//a[contains(text(), '" + playlistName + "')]")));
        WebElement playlistElement = driver.findElement(By.xpath("//section[@id='playlists']//ul//li//a[contains(text(), '" + playlistName + "')]"));
        actions.doubleClick(playlistElement).perform();
    }

    public void enterPlaylistName() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='name']")));
        WebElement playlistInputField = driver.findElement(By.cssSelector("input[name='name']"));
        playlistInputField.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        playlistInputField.sendKeys("HW22");
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public boolean doesPlaylistExist(String playlistName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='" + playlistName + "']")));
        WebElement playlistElement = driver.findElement(By.xpath("//a[text()='" + playlistName + "']"));
        return playlistElement.isDisplayed();
    }

}