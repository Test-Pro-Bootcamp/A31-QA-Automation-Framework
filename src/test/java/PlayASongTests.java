import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.HomePage;
import pages.LoginPage;

public class PlayASongTests extends BaseTest {

    @Test
    public void playASongTest()   {

        LoginPage loginPage = new LoginPage(getDriver());
        AllSongsPage allSongsPage =new AllSongsPage(getDriver());

        loginPage.logIn();
        allSongsPage.playASong();
        allSongsPage.isSongPlaying();

    }

}
