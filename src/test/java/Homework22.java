import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework22 extends BaseTest {

    @Test
    public void addSongToPlaylist() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login("test123@test.com", "te$t$tudent");

        createPlaylist("HW17");
        addSongToThePlaylist("Frantic", "HW17");
        navigateToPlaylist("HW17");

        Assert.assertTrue(confirmSongIsAdded("Frantic"));
        System.out.println("completed1");
    }

    @Test(enabled = true, priority = 1, description = "PlayASong")
    public void playSong() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login("test123@test.com", "te$t$tudent");

        allSongs();
        playSelectedSong("Dark Days");
        Assert.assertTrue(validateSongIsPlaying());
        System.out.println("completed2");
    }

    @Test(enabled = true, priority = 3, description = "DeleteAPlaylist")
    public void deletePlaylist() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login("test123@test.com", "te$t$tudent");

        createPlaylist("HW19");
        selectDesiredPlaylist("HW19");
        deleteDesiredPlaylist();
        Assert.assertTrue(deletionMsg());
        System.out.println("completed3");
    }

    @Test(enabled = true, priority = 2, description = "RenameAPlaylist")
    public void renamePlaylist() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login("test123@test.com", "te$t$tudent");

        createPlaylist("HW");
        choosePlaylist("HW");
        doubleClickChoosePlaylist("HW");
        contextClickChoosePlaylist("HW");
        enterPlaylistName();
        Assert.assertTrue(isUpdatedMsgPopUp());
        System.out.println("completed4");
    }
}
