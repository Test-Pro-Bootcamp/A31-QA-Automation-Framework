package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    By playListLocator = By.cssSelector(".playlist:nth-child(3)");
    By userAvatarIcon = By.cssSelector("img.avatar");
    By playlistInputLocator = By.cssSelector("input[name='name']");

    public HomePage( WebDriver givenDriver) {
        super(givenDriver);
    }

    public WebElement getUserAvatar () {
        return findElement(userAvatarIcon);
    }
    public WebElement moveToElement(By bySelector) {
        actions = new Actions(driver);
        WebElement playButton = findElement(bySelector);
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-testid='play-btn']")));
        // WebElement playButton = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
        actions.moveToElement(playButton).perform();
        return  playButton;
    }
    public void doubleClickFirstPlayList() {
        findElement(playListLocator);
        // actions = new Actions(driver);
        // wait.until(ExpectedConditions.visibilityOfElementLocated(playListLocator));
        // WebElement playlistElement = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        doubleClick(playListLocator);
    }

    public void enterPlaylistName(String playlistName){
        WebElement playlistInputField = findElement(playlistInputLocator);

        // WebElement playlistInputField = driver.findElement(By.cssSelector("input[name='name']"));
//        clear() does not work, element has an attribute of "required"
//            workaround is ctrl A (to select all) then backspace to clear then replace with new playlist name
        playlistInputField.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        playlistInputField.sendKeys(playlistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }
    public boolean doesPlaylistExist(String playlistName) {
        String locator = "//a[text()='"+ playlistName + "']";

        By editPlayListLocator = By.xpath(locator);
        return findElement(editPlayListLocator).isDisplayed();

    }

    public void choosePlaylist() {
        click(playListLocator);
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)"))).click();
    }
}
