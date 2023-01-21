import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.HomePage;
import pages.LoginPage;
import pages.PlaylistPage;

public class Homework17 extends BaseTest {

    @Test (enabled = true, priority = 0)
    public static void launchKoelTest () {

        //Confirm successful navigation
        WebElement koelLogo = driver.findElement(By.cssSelector("img[alt]"));

    }

    @Test (enabled = true, priority = 1)
    public static void loginValidUserNameTest () {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);


        //Enter tester username
        loginPage.provideEmail("amandaag39@gmail.com");

        //Enter password
        loginPage.providePassword("te$t$tudent");

        //Click login button
        loginPage.clickSubmitBtn();

        //Confirm successful login
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

    }


    @Test (enabled = true, priority = 2)
    public static void createPlaylistTest () {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        //Enter tester username
        loginPage.provideEmail("amandaag39@gmail.com");

        //Enter password
        loginPage.providePassword("te$t$tudent");

        //Click login button
        loginPage.clickSubmitBtn();

        //click add button
        homePage.clickAddButton();

        //select New Playlist from dropdown
        homePage.selectNewPlaylistFromDropdown();

        //create XYZ Playlist
        homePage.createXYZPlaylist();

        //confirm playlist creation
        Assert.assertTrue(homePage.confirmXYZPlaylist().isDisplayed());

    }

    @Test (enabled = true, priority = 3)
    public static void addSongToPlaylist (){

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        PlaylistPage playlistPage = new PlaylistPage(driver);

        //Enter tester username
        loginPage.provideEmail("amandaag39@gmail.com");

        //Enter password
        loginPage.providePassword("te$t$tudent");

        //Click login button
        loginPage.clickSubmitBtn();

        //navigate to 'All Songs'
        homePage.navigateToAllSongsPage();

        //right-click on song
        allSongsPage.rightClickSong();

        //click on add to
        homePage.clickAddTooButton();

        //click on XYZ Playlist in dropdown
        homePage.clickXYZInDropdown();

        //navigate to XYZ Playlist
        homePage.selectXYZPlaylist();

        //check for song in playlist
        playlistPage.confirmXYZPlaylist();


    }
}
