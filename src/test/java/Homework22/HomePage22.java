package Homework22;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage22 extends BasePage22 {


    public HomePage22 ( WebDriver givenDriver) { super(givenDriver);}


    public void doubleClickFirstPlaylist() {
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        actions.doubleClick(playlistElement).perform();
    }
    public void enterPlaylistName (String playlistName) {
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='name']")));
        (playlistInputField).sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        (playlistInputField).sendKeys(playlistName);
        (playlistInputField).sendKeys(Keys.ENTER);
    }

    public boolean doesPlaylistExist () {
        WebElement playlistElement = driver.findElement(By.xpath("//a[text()='Test Pro Playlist']"));
        return playlistElement.isDisplayed();
    }

}
