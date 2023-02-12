import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework22 extends BaseTest {

    @Test
    public void remamePlaylistTest() {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login("test123@test.com", "te$t$tudent");
        homePage.createPlaylist("HW");
        homePage.choosePlaylist("HW");
        homePage.doubleClickChoosePlaylist("HW");
        homePage.enterPlaylistName("HW22");
        Assert.assertTrue((homePage.getSuccessMsg()));
    }


}

