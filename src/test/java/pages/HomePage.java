package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    static WebDriverWait wait;

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    By addAPlaylist = By.xpath("//*[@class='fa fa-plus-circle create']");
    By clickNewPlaylist = By.xpath("//*[@data-testid='playlist-context-menu-create-simple']");
    By playlistName = By.cssSelector("input[placeholder='↵ to save']");
    By clickPlaylist = By.cssSelector(".playlist:nth-child(3)");
    By chooseName = By.cssSelector("input[name='name']");

    public void addPlaylist() {

        driver.findElement(addAPlaylist).click();
    }

    public void newPlaylist() {
        driver.findElement(clickNewPlaylist).click();
    }

    public void namePlaylist() {
        driver.findElement(playlistName).clear();
        driver.findElement(playlistName).click();
        driver.findElement(playlistName).sendKeys("best songs");
        driver.findElement(playlistName).sendKeys(Keys.ENTER);
    }

    public void doubleClickToPlaylist() {
        doubleClick(driver.findElement(clickPlaylist));
    }

    public static void choosePlaylist() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)"))).click();
    }
    public void newPlaylistName() {
        driver.findElement(chooseName).sendKeys(Keys.chord(Keys.COMMAND, "a", Keys.BACK_SPACE));
        driver.findElement(chooseName).sendKeys("Wild dream");
        driver.findElement(chooseName).sendKeys(Keys.ENTER);
    }

}
