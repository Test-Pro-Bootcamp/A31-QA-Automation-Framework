import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class Homework20 extends BaseTest {

    @Test(enabled = true, priority = 1, description = "delete a playlist test, waits instead of sleep")
    @Parameters({"PlaylistToDelete"})
    public static void deleteAPlaylist(String playlistToDelete) {
        //parameterization for baseURL is in BaseTests launchBrowser beforemethod already,
        //I added a playlist parameter in TestNG.xml just to play with it
        //but for the homework the baseURL parameterization is already in BaseTest launchBrowser method!
        login("jimmypvu@gmail.com", "te$t$tudent");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@data-testid='sidebar-create-playlist-btn']")));

        createTestPlaylist(playlistToDelete);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='playlist playlist']//a[contains(text(), '" + playlistToDelete + "')]")));

        deleteTestPlaylist(playlistToDelete);

    }

    public static void createTestPlaylist(String playlistToDelete) {
        WebElement addPlaylistBtn = driver.findElement(By.xpath("//i[@data-testid='sidebar-create-playlist-btn']"));
        addPlaylistBtn.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@data-testid='playlist-context-menu-create-simple']"))).click();

        WebElement newPlaylistNameField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@class='create']//input")));
        newPlaylistNameField.click();
        newPlaylistNameField.sendKeys(playlistToDelete, Keys.ENTER);
    }

    public static void deleteTestPlaylist(String playlistToDelete) {
        WebElement playlist = driver.findElement(By.xpath("//li[@class='playlist playlist']//a[contains(text(), '" + playlistToDelete + "')]"));
        playlist.click();

        WebElement delBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='del btn-delete-playlist']")));
        delBtn.click();

        WebElement successfulDeleteBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alertify-logs top right']//div[@class='success show']")));
        Assert.assertTrue(successfulDeleteBanner.isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='two-cols']//h1[contains(text(), 'Most Played')]")));

        List<WebElement> playlists = driver.findElements(By.xpath("//section[@id='playlists']//li/a"));
        for (WebElement pl : playlists) {
            String name = pl.getText();
            if (name.equals(playlistToDelete)) {
                Assert.assertTrue(false);
            }
        }

    }
}