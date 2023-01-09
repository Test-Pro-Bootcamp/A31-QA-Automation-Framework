import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{

    @Test(enabled = true, priority = 1, description = "delete a playlist test")
    @Parameters({"PlaylistToDelete"})
    public static void deleteAPlaylist(String playlistToDelete) throws InterruptedException {
        //parameterization for baseURL is in BaseTests launchBrowser beforemethod already,
        //I added a playlist parameter in TestNG.xml just to play with it
        //but for the homework the baseURL parameterization is already in BaseTest launchBrowser method!
        login("jimmypvu@gmail.com", "te$t$tudent");
        Thread.sleep(750);

        createTestPlaylist(playlistToDelete);
        Thread.sleep(750);

        deleteTestPlaylist(playlistToDelete);
        Thread.sleep(750);

    }

    public static void createTestPlaylist(String playlistToDelete) throws InterruptedException{
        WebElement addPlaylistBtn = driver.findElement(By.xpath("//i[@data-testid='sidebar-create-playlist-btn']"));
        addPlaylistBtn.click();
        Thread.sleep(750);

        WebElement newPlaylistBtn = driver.findElement(By.xpath("//li[@data-testid='playlist-context-menu-create-simple']"));
        newPlaylistBtn.click();
        Thread.sleep(750);

        WebElement newPlaylistNameField = driver.findElement(By.xpath("//form[@class='create']//input"));
        newPlaylistNameField.click();
        Thread.sleep(500);
        newPlaylistNameField.sendKeys(playlistToDelete);
        Thread.sleep(500);
        newPlaylistNameField.sendKeys(Keys.ENTER);
        Thread.sleep(750);
    }

    public static void deleteTestPlaylist(String playlistToDelete) throws InterruptedException {
        WebElement playlist = driver.findElement(By.xpath("//li[@class='playlist playlist']//a[contains(text(), '"+playlistToDelete+"')]"));
        playlist.click();
        Thread.sleep(750);

        WebElement deletePlaylistBtn = driver.findElement(By.xpath("//button[@class='del btn-delete-playlist']"));
        deletePlaylistBtn.click();
        Thread.sleep(500);

        WebElement successfulDeleteBanner = driver.findElement(By.xpath("//div[@class='alertify-logs top right']//div[@class='success show']"));
        Assert.assertTrue(successfulDeleteBanner.isDisplayed());
    }
}
