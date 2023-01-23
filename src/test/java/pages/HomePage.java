package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {


    By userAvatarIcon = By.cssSelector("img.avatar");
    static By playlistLocator = By.cssSelector(".playlist:nth-child(3)");
    static By playlistNameLocator = By.cssSelector("input[name='name']");

    static By playlistElementLocator = By.xpath("//a[contains (text(), 'name')]");



    public HomePage( WebDriver givenDriver) {
        super(givenDriver);
    }

    public WebElement getUserAvatar () {
        return findElement(userAvatarIcon);
    }

    public static void doubleClickChoosePlaylist() {
        WebElement playlistElement = driver.findElement(playlistLocator);
        actions.doubleClick(playlistElement).perform();
    }

    public static void enterPlaylistName(String playlistName) {

        WebElement playlistInputField = driver.findElement(playlistNameLocator);
//        clear() does not work, element has an attribute of "required"
//            workaround is ctrl A (to select all) then backspace to clear then replace with new playlist name

        playlistInputField.sendKeys((Keys.chord(Keys.COMMAND, "a", Keys.DELETE)));
        playlistInputField.sendKeys(playlistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public static boolean doesPlaylistExist(String name) {

        WebElement playlistElement = driver.findElement(playlistElementLocator);
        return playlistElement.isDisplayed();
    }

}