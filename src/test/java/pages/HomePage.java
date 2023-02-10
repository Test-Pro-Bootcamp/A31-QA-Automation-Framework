package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    @FindBy(css = "img.avatar")
    private WebElement userAvatarIcon;
    private By byuserAvatarIcon = By.cssSelector("img.avatar");
    @FindBy(css = "a.songs")
    private WebElement allSongTabLocator;
    @FindBy(css = "i[class='fa fa-plus-circle create']")
    private WebElement plusIcon;
    @FindBy(css = "li[data-testid='playlist-context-menu-create-simple']")
    private WebElement newPlaylistButton;
    @FindBy(css = "input[name='name']")
    private WebElement playlistInputField;
    @FindBy(css = "div.success.show")
    private WebElement successPopup;
    private By bysuccessPopup = By.cssSelector("div.success.show");
    @FindBy(xpath = "//span[@data-testid='play-btn']")
    private WebElement playButton;
    private By byplayButton = By.xpath("//span[@data-testid='play-btn']");
    @FindBy(css = "[class='del btn-delete-playlist']")
    private WebElement deleteButton;
    private By byviewAllSearchButton = By.cssSelector("button[data-test='view-all-songs-btn']");
    @FindBy(css = "[type='search']")
    private WebElement searchFieldLocator;

    public HomePage(WebDriver givenDriver) {

        super(givenDriver);
    }

    public WebElement getUserAvatar() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byuserAvatarIcon));
        return userAvatarIcon;
    }
    public void clickAllSongsTab() {
        wait.until(ExpectedConditions.elementToBeClickable(allSongTabLocator)).click();
    }

    public void createPlaylist(String playlistName) {
        clickPlusIcon();
        clickNewPlaylistButton();
        createAPlaylistName(playlistName);
    }

    public void clickPlusIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(plusIcon)).click();
    }

    public void clickNewPlaylistButton() {
        wait.until(ExpectedConditions.elementToBeClickable(newPlaylistButton)).click();
    }
    public void createAPlaylistName(String playlistName) {
        wait.until(ExpectedConditions.elementToBeClickable(playlistInputField)).sendKeys(playlistName);
        playlistInputField.submit();
    }

    public void choosePlaylist(String playlistName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']//ul//li//a[contains(text(), '" + playlistName + "')]"))).click();
    }

       public WebElement doubleClickChoosePlaylist(String playlistName) {

        WebElement playlistElement = driver.findElement(By.xpath("//section[@id='playlists']//ul//li//a[contains(text(), '" + playlistName + "')]"));
        actions.doubleClick(playlistElement).perform();
        return driver.findElement(By.xpath("//section[@id='playlists']//ul//li//a[contains(text(), '" + playlistName + "')]"));
    }

    public void enterPlaylistName(String playlistName) {
        wait.until(ExpectedConditions.elementToBeClickable(playlistInputField));
        playlistInputField.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        playlistInputField.sendKeys(playlistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }
    public boolean playlistRenamedMsgisDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(bysuccessPopup));
        return successPopup.isDisplayed();
    }

    public void selectPlaylistToDelete(String playlistName) {
        WebElement selectAPlaylistElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='playlists']//li[@class='playlist playlist']//a[contains(text(),'" + playlistName + "')]")));
        selectAPlaylistElement.click();
    }
    public void deletePlaylist() {
        wait.until(ExpectedConditions.elementToBeClickable(deleteButton)).click();
    }

    //Validate the playlist is deleted
    public boolean isplaylistDeleted() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(bysuccessPopup));
        return successPopup.isDisplayed();
    }
    public WebElement hoverPlay() {
        WebElement playBtn = driver.findElement(byplayButton);
        actions.moveToElement(playButton).perform();
        return driver.findElement(byplayButton);
    }
    public void searchSong(String songName){
        wait.until(ExpectedConditions.elementToBeClickable(searchFieldLocator)).click();
        searchFieldLocator.sendKeys(songName);
    }
    public void viewAllSearchResults() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byviewAllSearchButton)).click();
    }

}