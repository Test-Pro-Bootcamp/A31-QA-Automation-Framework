import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.AllSongPage;
import pages.LoginPage;

public class Homework17 extends BaseTest {

    @Test
    public static void AddSongToPlaylist() throws InterruptedException {

        AllSongPage allSongPage = new AllSongPage(driver);
        LoginPage loginPage = new LoginPage(driver);


        loginPage.logIn();
        allSongPage.chooseAllSongsList();
        allSongPage.contextClickFirstSong();
        allSongPage.addToPlayList();

    }
}
