import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class homework19 extends BaseTest {

    @Test
    public static void deleteAPlaylistTest() throws Exception {
        login("demo@class.com", "te$t$tudent");

        WebElement addPlaylistButton = driver.findElement(By.cssSelector("[data-testid='sidebar-create-playlist-btn']"));
        addPlaylistButton.click();

        Thread.sleep(2000);

        WebElement clickNewPlaylist = driver.findElement(By.cssSelector("[data-testid='playlist-context-menu-create-simple']"));
        clickNewPlaylist.click();

        Thread.sleep(2000);

        WebElement playlistName = driver.findElement(By.cssSelector("form>input[name='name']"));
        playlistName.click();
        playlistName.sendKeys("Playlist 19");
        playlistName.sendKeys(Keys.RETURN);

        Thread.sleep(2000);

        Actions actions = new Actions(driver);
        WebElement elementLocator = driver.findElement(By.cssSelector("li.playlist>a.active"));
        actions.contextClick(elementLocator).perform();

        Thread.sleep(4000);

        WebElement clickDeleteButton = driver.findElement(By.xpath("//nav/ul/li[2]"));
        clickDeleteButton.click();

        WebElement successMessage = driver.findElement(By.cssSelector("div.success"));
        Assert.assertTrue(successMessage.isDisplayed());

    }

}
