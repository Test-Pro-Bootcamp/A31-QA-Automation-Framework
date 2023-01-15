import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {

    @Test
    public static void deletePlaylist() throws InterruptedException {

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

        //select XYZPlaylist
        selectXYZPlaylist();

        //click deletePlaylistButton
        WebElement deletePlaylistButton = driver.findElement(By.cssSelector("button.del.btn-delete-playlist"));
        deletePlaylistButton.click();


        //validate playlist deletion
        WebElement deletedPlaylist = driver.findElement(By.xpath("//div[@class='success show' and contains(text(),'Deleted playlist')]"));
        Assert.assertTrue(deletedPlaylist.isDisplayed());

    }
}

