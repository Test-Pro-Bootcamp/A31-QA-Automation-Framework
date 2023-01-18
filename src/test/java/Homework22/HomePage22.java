package Homework22;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage22 extends BasePage22 {

    public HomePage22( WebDriver givenDriver) { super (givenDriver); }

    By firstPlaylist = By.cssSelector(".playlist:nth=child(3)");
    By playlistInputField = By.cssSelector("input[name='name']");

    public void doubleClickFirstPlaylist() { doubleClick(driver.findElement(firstPlaylist));}
    public void enterPlaylistName (String playlistName) {
        driver.findElement(playlistInputField).sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        driver.findElement(playlistInputField).sendKeys(playlistName);
        driver.findElement(playlistInputField).sendKeys(Keys.ENTER);
    }

    public HomePage22 getUserAvatar() {
        driver.findElement(By.xpath(("//*[@id=\"userBadge\"]")));
        return this;
    }

    public boolean doesPlaylistExist(String playlistName) {
        WebElement playlistElement = driver.findElement(By.xpath("//a[text()='Test Pro Playlist']"));
        return playlistElement.isDisplayed();
    }

    public boolean isDisplayed() { return true;}
}
