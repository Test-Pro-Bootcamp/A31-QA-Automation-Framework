package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{

    //WebElements
    @FindBy (css="[class='fa fa-plus-circle create']")
    WebElement createPlaylistButton;
    @FindBy (css="li[data-testid='playlist-context-menu-create-simple']")
    WebElement newPlaylistOption;
    @FindBy (css="input[name='name']")
    WebElement playlistInputField;

    //locator
    By avatarIcon = By.cssSelector("img.avatar");

    //Constructor
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Page methods
    public WebElement userAvatarIcon() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(avatarIcon));
    }

    public HomePage createCustomPlaylist(String playlistName) {
        waitClick(createPlaylistButton);
        createPlaylistButton.click();
        newPlaylistOption.click();
        playlistInputField.sendKeys(playlistName);
        playlistInputField.submit();
        return this;
    }

    public HomePage doubleClickFirstPlaylist() {
        doubleClick(firstPlaylist);
        return this;
    }

    public HomePage renamePlaylist(String newPlaylistName) {
        waitClick(playlistInputField);
        playlistInputField.sendKeys(Keys.chord(Keys.COMMAND, "a", Keys.BACK_SPACE));
        playlistInputField.sendKeys(newPlaylistName);
        playlistInputField.sendKeys(Keys.ENTER);
        return this;
    }
}
