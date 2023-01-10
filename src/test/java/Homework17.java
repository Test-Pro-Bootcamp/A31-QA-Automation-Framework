import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

    @Test (enabled = true, priority = 0)
    public static void launchKoelTest () {

        //Confirm successful navigation
        WebElement koelLogo = driver.findElement(By.cssSelector("img[alt]"));

    }

    @Test (enabled = true, priority = 1)
    public static void loginValidUserNameTest () {

        //Enter tester username
        provideEmail("amandaag39@gmail.com");

        //Enter password
        providePassword("te$t$tudent");

        //Click login button
        clickLoginButton();

        //Confirm successful login
        confirmLogin();

    }

    @Test (enabled = true, priority = 2)
    public static void createPlaylistTest () {

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

    }

    @Test (enabled = true, priority = 3)
    public static void addSongToPlaylist (){

        //Enter tester username
        provideEmail("amandaag39@gmail.com");

        //Enter password
        providePassword("te$t$tudent");

        //Click login button
        clickLoginButton();

        //navigate to 'All Songs'
        navigateToAllSongsPage();

        //right-click on song
        rightClickSong();

        //click on add to
        WebElement addTooButton=driver.findElement(By.xpath("//*[@id=\"app\"]/nav/ul/li[4]"));
        addTooButton.click();

        //click on XYZ Playlist in dropdown
        WebElement xyzPlaylistDropdown=driver.findElement(By.xpath("//*[@id=\"app\"]/nav/ul/li[4]/ul/li[10]"));
        xyzPlaylistDropdown.click();

        //navigate to XYZ Playlist
        selectXYZPlaylist();

        //check for song in playlist
        WebElement waitingOnATrainSongPlaylist=driver.findElement(By.xpath("//*[@id=\"playlistWrapper\"]/div/div/div[1]/table/tr/td[2]"));
        Assert.assertTrue(waitingOnATrainSongPlaylist.isDisplayed());

    }
}
