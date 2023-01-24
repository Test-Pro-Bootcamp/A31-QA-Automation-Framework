import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
import pages.LoginPage;
import pages.HomePage;

public class Homework23 extends BaseTest {
    @Test
    public void renamePlaylist () throws InterruptedException {
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    loginPage.logIn();
    homePage.addNewPlaylistButton();
    homePage.newPlaylistButton();
    homePage.provideName();
    homePage.editButtonClick();
    homePage.clickEdit();
    homePage.rename();
    homePage.checkRename();
    }
}

