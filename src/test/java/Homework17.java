import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework17 extends BaseTest {

    @Test (enabled = true, priority = 0)
    public void launchKoelTest () {

        //Confirm successful navigation
        WebElement koelLogo = driver.findElement(By.cssSelector("img[alt]"));
    }

    @Test (enabled = true, priority = 1)
    public void loginValidUserNameTest () {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        //Enter tester username
        loginPage.provideEmail("amandaag39@gmail.com");

        //Enter password
        loginPage.providePassword("te$t$tudent");

        //Click login button
        loginPage.clickSubmitBtn();

        //Confirm successful login
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

    }


//    @Test (enabled = true, priority = 2)
//    public void createPlaylistTest () {
//
//        LoginPage loginPage = new LoginPage(getDriver());
//        HomePage homePage = new HomePage(getDriver());
//
//        //Enter tester username
//        loginPage.provideEmail("amandaag39@gmail.com");
//
//        //Enter password
//        loginPage.providePassword("te$t$tudent");
//
//        //Click login button
//        loginPage.clickSubmitBtn();
//
//        //click add button
//        homePage.clickAddButton();
//
//        //select New Playlist from dropdown
//        homePage.selectNewPlaylistFromDropdown();
//
//        //create XYZ Playlist
//        homePage.createXYZPlaylist();
//
//        //confirm playlist creation
//        Assert.assertTrue(homePage.confirmXYZPlaylist().isDisplayed());
//
//    }
//
//    @Test (enabled = true, priority = 3)
//    public void addSongToPlaylist () {
//
//        LoginPage loginPage = new LoginPage(getDriver());
//        HomePage homePage = new HomePage(getDriver());
//        AllSongsPage allSongsPage = new AllSongsPage(getDriver());
//        PlaylistPage playlistPage = new PlaylistPage(getDriver());
//
//        //Enter tester username
//        loginPage.provideEmail("amandaag39@gmail.com");
//
//        //Enter password
//        loginPage.providePassword("te$t$tudent");
//
//        //Click login button
//        loginPage.clickSubmitBtn();
//
//        //navigate to 'All Songs'
//        homePage.navigateToAllSongsPage();
//
//        //right-click on song
//        allSongsPage.rightClickSong();
//
//        //click on add to
//        homePage.clickAddTooButton();
//
//        //click on XYZ Playlist in dropdown
//        homePage.clickXYZInDropdown();
//
//        //navigate to XYZ Playlist
//        homePage.selectXYZPlaylist();
//
//        //check for song in playlist
//        Assert.assertTrue(playlistPage.confirmXYZPlaylist().isDisplayed());
//
//    }

}
