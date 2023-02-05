import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class renamePlaylistTest extends BaseTest {

    public static String playlistName = "Test Playlist";

    @Test
    public void renamePlaylist() {

        HomePage homePage = new HomePage(driver);

        //Enter tester username
        provideEmail("amandaag39@gmail.com");

        //Enter password
        providePassword("te$t$tudent");

        //Click login button
        clickLoginButton();

        //click add button
        homePage.clickAddButton();

        //select New Playlist from dropdown
        homePage.selectNewPlaylistFromDropdown();

        //create XYZ Playlist
        homePage.createXYZPlaylist();

        //confirm playlist creation
        Assert.assertTrue(homePage.confirmXYZPlaylist().isDisplayed());

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
