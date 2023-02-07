import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSongPage;
import pages.LoginPage;

import java.time.Duration;


public class TGHW17 extends BaseTest {

    @Test
    public static void AddSongToPlaylist() throws InterruptedException {


        //       WebDriver driver = new ChromeDriver();
        //      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //       String url = "https://bbb.testpro.io/";
        //       Thread.sleep(2000);
        //      driver.get(url);
        //      Assert.assertEquals(driver.getCurrentUrl(), url);


        AllSongPage allSongPage = new AllSongPage(driver);
        LoginPage loginPage = new LoginPage(driver);


        loginPage.logIn();
        allSongPage.chooseAllSongsList();
        allSongPage.contextClickFirstSong();
        allSongPage.addToPlayList();

    }
}