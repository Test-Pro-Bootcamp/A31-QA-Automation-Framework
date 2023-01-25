import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework25 extends BaseTest {
    @Test
    public void renamePlaylist() {

       LoginPage loginPage = new LoginPage(getDriver());
       HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("test123@test.com")
                .providePassword("te$t$tudent")
                .clickSubmit();

        homePage.createPlaylist("HW");
        homePage.choosePlaylist("HW");
        homePage.doubleClickChoosePlaylist("HW");
        homePage.enterPlaylistName("HW25");
        Assert.assertTrue((homePage.getSuccessMsg()));
    }

    @Test
    public void deletePlaylist() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("test123@test.com")
                .providePassword("te$t$tudent")
                .clickSubmit();

        homePage.createPlaylist("HWDelete");
        homePage.choosePlaylist("HWDelete");
        homePage.deleteDesiredPlaylist();

        Assert.assertTrue(homePage.deletionMsg());
    }
}
