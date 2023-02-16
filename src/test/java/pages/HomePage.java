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

    public HomePage doesPlaylistExist(String playlistName) {
        wait.until(ExpectedConditions.elementToBeClickable(playListElement));
  //              return playlistElement.isDisplayed();
        Assert.assertTrue(playListElement.isDisplayed());
        return this;
    }

    public boolean isDisplayed() {
        return true;
    }

    public void choosePlaylist() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
    }

    public void conTextClick() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        WebElement element = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        Actions action = new Actions(driver);
        action.contextClick(element).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[data-testid^='playlist-context-menu-edit']"))).click();
    }

    public void newName() {
        WebElement inputNewName = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='name']")));
        inputNewName.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        String newPlayListName = "Tatsiana";
        inputNewName.sendKeys(newPlayListName);
        inputNewName.sendKeys(Keys.ENTER);

    }

    public boolean checkPlayList() {
        String newPlayListName = "Tatsiana";
        WebElement createdPlayList = driver.findElement(By.xpath("//a[text()='" + newPlayListName + "']"));
        return createdPlayList.isDisplayed();
    }

    public boolean doesNotLogin() {
        WebElement fieldEmail = driver.findElement(By.cssSelector("[type='email']"));
        return fieldEmail.isDisplayed();
    }

}

