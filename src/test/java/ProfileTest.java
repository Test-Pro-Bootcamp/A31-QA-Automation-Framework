import Pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Pages.LoginPage;
import Pages.ProfilePage;

import java.net.MalformedURLException;
import java.time.Duration;

public class ProfileTest extends BaseTest {

    @BeforeMethod
    @Parameters({"BaseUrl"})
    public void launchBrowser_main(String BaseUrl) throws MalformedURLException {
        this.launchBrowser(BaseUrl);
    }

    @AfterMethod
    public void closeBrowser_main() {
        this.closeBrowser();
    }
    @Test
    public void changeTheme() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        ProfilePage profilePage = new ProfilePage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("shalinibaronia@gmail.com").providePassword("te$t$tudent").clickSubmit();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        homePage.getUserAvatar().click();
        Thread.sleep(2000);
        profilePage.chooseVioletTheme()
                .isVioletThemeSelected();
    }



}