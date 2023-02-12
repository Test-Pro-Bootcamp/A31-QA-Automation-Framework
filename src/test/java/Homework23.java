import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework23 extends BaseTest {
    @Test
    public void renamePlaylist() {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("simplyd2d@gmail.com")
                .providePassword("te$t$tudent")
                .clickSubmit();

        homePage.createPlaylist("Homework");
        homePage.choosePlaylist("Homework");
        homePage.doubleClickChoosePlaylist("Homework");
        homePage.enterPlaylistName("Homework23");
        Assert.assertTrue((homePage.getSuccessMsg()));
    }

    @Test
    public void deletePlaylist() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("simplyd2d@gmail.com")
                .providePassword("te$t$tudent")
                .clickSubmit();

        homePage.createPlaylist("HomeworkDelete");
        homePage.choosePlaylist("HomeworkDelete");
        homePage.deleteDesiredPlaylist();

        Assert.assertTrue(homePage.deletionMsg());

    }

}
