import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.HomePage;
import pages.LoginPage;
import pages.TestProPlaylistPage;

public class Homework23 extends BaseTest{

//    public Homework23(WebDriver givenDriver) {
//        super(givenDriver);for pom/page factory
//    }

    @Test
    public void pageFactoryPlaylist()  {
        String playListName = "Test Pro Playlist";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);


        loginPage.provideEmail("demo@class.com")
                 .providePassword("te$t$tudent")
                .clickSubmitBtn();
        homePage.doubleClickChoosePlaylist()
                .enterPlaylistName(playListName);
        Assert.assertTrue(homePage.doesPlaylistExist());

    }
}
