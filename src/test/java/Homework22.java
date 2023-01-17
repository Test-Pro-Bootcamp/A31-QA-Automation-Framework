import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.BasePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;

import java.sql.Driver;


@Test

    public class Homework22 extends BaseTest {

        @Test
        public void renamePlaylist() {
            String playlistname = "Starry nights";

            LoginPage loginPage = new LoginPage(driver);
            HomePage homePage = new HomePage(driver);

            loginPage.logIn();
            homePage.doubleClickPlaylist();
            homePage.changePlaylistName(playlistname);
            Assert.assertTrue(homePage.doesPlaylistExist(playlistname));
        }
    }

