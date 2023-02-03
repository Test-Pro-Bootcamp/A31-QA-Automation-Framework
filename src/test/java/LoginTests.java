import Pages.HomePage;
import Pages.LoginPage;
import io.cucumber.java.After;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.time.Duration;

public class LoginTests extends BaseTest {
    
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
    public void LoginValidEmailPasswordTest () {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homepage = new HomePage(getDriver());


        loginPage.provideEmail("shalinibaronia@gmail.com").providePassword("te$t$tudent").clickSubmit();
        Assert.assertTrue(homepage.getUserAvatar().isDisplayed());
    }

    @Test
    public void loginInvalidEmailValidPasswordTest () {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homepage = new HomePage(getDriver());


        loginPage.provideEmail("invalid@class.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmit();

        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }
}