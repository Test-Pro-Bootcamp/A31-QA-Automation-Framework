package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;


public class HomePage extends BasePage {

    @FindBy(css = "input[name='name']")
    WebElement playlistInputField;
    @FindBy(css = "img.avatar")
    WebElement userAvatarIcon;
    @FindBy(css = "div.success.show")
    private WebElement successMsg;
    @FindBy(xpath = "//a[text()='+playlistName+']")
    WebElement playListElement;
    @FindBy(css = ".playlist:nth-child(3)")
    WebElement playList;
    @FindBy(css = "[type='email']")
    WebElement emailField;
    @FindBy(css = "div.alertify-logs.top.right")
    WebElement createdMessLocator;
    private By createdPlayListMess = By.cssSelector("div.alertify-logs.top.right");

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void enterPlaylistName(String playlistName) {
        playlistInputField.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        playlistInputField.sendKeys(playlistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public WebElement getUserAvatar() {
        return
                wait.until(ExpectedConditions.visibilityOf(userAvatarIcon));
    }

    public boolean getSuccessPopUp() {
        wait.until(ExpectedConditions.visibilityOf(successMsg));
        return successMsg.isDisplayed();
    }

    public boolean isPlaylistCreatedMessageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(createdPlayListMess));
        return createdMessLocator.isDisplayed();
    }

    public boolean checkPlayList() {
        String newPlayListName = "Tatsiana1";
        WebElement createdPlayList = driver.findElement(By.xpath("//a[text()='" + newPlayListName + "']"));
        return createdPlayList.isDisplayed();
    }

    public boolean isDisplayed() {
        return true;
    }

    public void choosePlaylist() {
        waitvisibility(playList);
    }

    public void conTextClick() {
        waitvisibility(playList);
        Actions action = new Actions(driver);
        action.contextClick(playList).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[data-testid^='playlist-context-menu-edit']"))).click();
    }

    public void newName() {
        waitClick(playlistInputField);
        playlistInputField.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        String newPlayListName = "Tatsiana1";
        playlistInputField.sendKeys(newPlayListName);
        playlistInputField.sendKeys(Keys.ENTER);
    }


    public boolean doesNotLogin() {
        waitvisibility(emailField);
        return emailField.isDisplayed();
    }

}

