package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class HomePage extends BasePage {
    private String playlistName = "Summer Songs";

    By userAvatarIcon = By.cssSelector("img.avatar");
    private  By playlistElementLocator = By.xpath("//a[text() = '"+playlistName+"']");


    @FindBy(css=".playlist:nth-child(3)")
    private WebElement playlistLocator;

    @FindBy(css="input[name='name']")
    private WebElement playlistNameLocator;

    public HomePage( WebDriver givenDriver) {
        super(givenDriver);
    }

    public WebElement getUserAvatar () {
        return findElement(userAvatarIcon);
    }

    public void doubleClickChoosePlaylist() {
        wait.until(ExpectedConditions.elementToBeClickable(playlistLocator));
        actions.doubleClick(playlistLocator).perform();
    }

    public void enterPlaylistName() {
        wait.until(ExpectedConditions.elementToBeClickable(playlistNameLocator));
        playlistNameLocator.sendKeys((Keys.chord(Keys.COMMAND, "a", Keys.DELETE)));
        playlistNameLocator.sendKeys(playlistName);
        playlistNameLocator.sendKeys(Keys.ENTER);
    }

    public boolean doesPlaylistExist() {
        wait.until(ExpectedConditions.presenceOfElementLocated(playlistElementLocator));
        WebElement playlistElement = driver.findElement(playlistElementLocator);
        return playlistElement.isDisplayed();
    }

}