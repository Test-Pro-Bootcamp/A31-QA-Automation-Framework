import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static org.openqa.selenium.Keys.ENTER;

public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        login("demo@class.com", "te$t$tudent");

        WebElement addPlaylistButton = driver.findElement(By.cssSelector("[data-testid=\"sidebar-create-playlist-btn\"]"));
        addPlaylistButton.click();

        WebElement newPlaylistButton = driver.findElement(By.cssSelector("[data-testid=\"playlist-context-menu-create-simple\"]"));
        newPlaylistButton.click();

        Thread.sleep(2000);

        WebElement playlistNameField = driver.findElement(By.cssSelector("form>input[name=\"name\"]"));
        playlistNameField.click();
        playlistNameField.sendKeys("New Playlist");
        playlistNameField.sendKeys(ENTER);

        Thread.sleep(2000);

        WebElement homeButton = driver.findElement(By.cssSelector("li>a.home"));
        homeButton.click();

        Thread.sleep(2000);

        Actions action = new Actions(driver);
        WebElement rightClickSong = driver.findElement(By.xpath("//span[contains(text(), 'Mid-Air Machine')]"));
        action.contextClick(rightClickSong).perform();

        WebElement clickAddTo = driver.findElement(By.xpath("//li[contains(text(), 'Add To')]"));
        clickAddTo.click();

        Thread.sleep(2000);

        WebElement clickPlaylist = driver.findElement(By.cssSelector("li.has-sub>ul>li.playlist"));
        clickPlaylist.click();

        closeBrowser();
    }

}
