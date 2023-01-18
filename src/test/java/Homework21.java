import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {

    public static String playlistName = "Test Playlist";

    @Test
    public static void renamePlaylist() {
        //Enter tester username
        provideEmail("amandaag39@gmail.com");

        //Enter password
        providePassword("te$t$tudent");

        //Click login button
        clickLoginButton();

        //click add button
        clickAddButton();

        //select New Playlist from dropdown
        selectNewPlaylistFromDropdown();

        //create XYZ Playlist
        createXYZPlaylist();

        //confirm playlist creation
        confirmXYZPlaylist();

        //right-click XYZ Playlist
        rightClickXYZPlaylist();

        //click Edit
//        WebElement editPlaylistButton = driver.findElement(By.xpath("//li[text()='Edit']"));
        WebElement editPlaylistButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='Edit']")));
        editPlaylistButton.click();

        //clear text field
        //WebElement playlistTextField = driver.findElement(By.cssSelector("input[data-testid='inline-playlist-name-input']"));
        WebElement playlistTextField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[data-testid='inline-playlist-name-input']")));
        playlistTextField.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        playlistTextField.sendKeys(playlistName);
        playlistTextField.sendKeys(Keys.ENTER);

        //confirm presence of playlist with edited name
        //WebElement editedXYZPlaylist = driver.findElement(By.xpath("//a[text()='"+playlistName +"']"));
        WebElement editedXYZPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='"+playlistName +"']")));
        Assert.assertTrue(editedXYZPlaylist.isDisplayed());

    }

}
