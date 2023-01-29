package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.openqa.selenium.support.How.*;

public class HomePage extends BasePage {
    private static String playlistName = "Summer Songs";
    private  static By playlistElementLocator = By.xpath("//a[text() = '"+playlistName+"']");

    @FindBy(css="img.avatar")
    private WebElement userAvatarIcon;

    @FindBy(css=".playlist:nth-child(3)")
    private static WebElement playlistLocator;

    @FindBy(css="input[name='name']")
    private static WebElement playlistNameLocator;

    public HomePage( WebDriver givenDriver) {

        super(givenDriver);
    }

    public WebElement getUserAvatar () {
        return userAvatarIcon;
    }

    public static void doubleClickChoosePlaylist() {
        wait.until(ExpectedConditions.elementToBeClickable(playlistLocator));
        actions.doubleClick(playlistLocator).perform();
    }

    public static void enterPlaylistName() {
        wait.until(ExpectedConditions.elementToBeClickable(playlistNameLocator));
        playlistNameLocator.sendKeys((Keys.chord(Keys.COMMAND, "a", Keys.DELETE)));
        playlistNameLocator.sendKeys(playlistName);
        playlistNameLocator.sendKeys(Keys.ENTER);
    }

    public static boolean doesPlaylistExist() {
        wait.until(ExpectedConditions.presenceOfElementLocated(playlistElementLocator));
        WebElement playlistElement = driver.findElement(playlistElementLocator);
        return playlistElement.isDisplayed();
    }

}