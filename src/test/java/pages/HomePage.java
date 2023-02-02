package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //WebElement
    @FindBy(css = "img.avatar")
    private WebElement userAvatarIcon;
    @FindBy(css = "i[class='fa fa-plus-circle create']")
    private WebElement plusIcon;
    @FindBy(css = "li[data-testid='playlist-context-menu-create-simple']")
    private WebElement newPlaylistButton;
    @FindBy(css = "input[name='name']")
    private WebElement playlistInputField;
    @FindBy(css = "[class='del btn-delete-playlist']")
    private WebElement deleteButton;
    @FindBy(css = "div.success.show")
    private WebElement successMsg;
    @FindBy(xpath = "//li[contains(text(),'Edit')]")
    private WebElement editPlaylistButton;

    public WebElement getUserAvatar() {
        return userAvatarIcon;
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
        plusIcon.click();
    }

    public void clickNewPlaylistButton() {
        newPlaylistButton.click();
    }

    public void createAPlaylistName(String playlistName) {
        playlistInputField.sendKeys(playlistName);
        playlistInputField.submit();
    }

    public boolean confirmCreatedPlaylist(String pName) {
        WebElement customPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='playlists']//li[@class='playlist playlist']//a[contains(text(),'" + pName + "')]")));
        return customPlaylist.isDisplayed();
    }

    //Navigate and select a playlist
    public void selectDesiredPlaylist(String playlistName) {
        WebElement selectAPlaylistElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='playlists']//li[@class='playlist playlist']//a[contains(text(),'" + playlistName + "')]")));
        selectAPlaylistElement.click();
    }

    //Delete the selected playlist
    public void deleteDesiredPlaylist() {
        deleteButton.click();
    }

    //Validate the playlist is deleted
    public boolean deletionMsg() {
        return successMsg.isDisplayed();
    }

    //Navigate and select a playlist
    public void choosePlaylist(String playlistName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']//ul//li//a[contains(text(), '" + playlistName + "')]"))).click();
    }

    public void doubleClickChoosePlaylist(String playlistName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']//ul//li//a[contains(text(), '" + playlistName + "')]")));
        WebElement playlistElement = driver.findElement(By.xpath("//section[@id='playlists']//ul//li//a[contains(text(), '" + playlistName + "')]"));
        actions.doubleClick(playlistElement).perform();
    }

    public void contextClickChoosePlaylist(String playlistName) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='playlists']//ul//li//a[contains(text(), '" + playlistName + "')]")));
        WebElement playlistElement = driver.findElement(By.xpath("//section[@id='playlists']//ul//li//a[contains(text(), '" + playlistName + "')]"));
        actions.contextClick(playlistElement).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'Edit')]"))).click();
    }

    public void enterPlaylistName(String playlistName) {
        playlistInputField.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        playlistInputField.sendKeys(playlistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public boolean getSuccessMsg() {
        return successMsg.isDisplayed();
    }
}
