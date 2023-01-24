package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    static WebDriverWait wait;

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(xpath = "//*[@class='fa fa-plus-circle create']")
    WebElement addAPlaylist;
    @FindBy(xpath = "//*[@data-testid='playlist-context-menu-create-simple']")
    WebElement clickNewPlaylist;
    @FindBy(css = "input[placeholder='↵ to save']")
    WebElement playlistName;
    @FindBy(css = ".playlist:nth-child(3)")
    WebElement clickPlaylist;
    @FindBy(css = "input[name='name']")
    WebElement chooseName;

    public HomePage addPlaylist() {
        addAPlaylist.click();
        return this;
    }

    public HomePage newPlaylist() {
        clickNewPlaylist.click();
        return this;
    }

    public HomePage namePlaylist() {
        playlistName.clear();
        playlistName.click();
        playlistName.sendKeys("best songs");
        playlistName.sendKeys(Keys.ENTER);
        return this;
    }

    public HomePage doubleClickToPlaylist() {
        doubleClick(clickPlaylist);
        return this;
    }

    public static void choosePlaylist() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)"))).click();
    }

    public HomePage newPlaylistName() {
        chooseName.sendKeys(Keys.chord(Keys.COMMAND, "a", Keys.BACK_SPACE));
        chooseName.sendKeys("Wild dream");
        chooseName.sendKeys(Keys.ENTER);
        return this;
    }

}
