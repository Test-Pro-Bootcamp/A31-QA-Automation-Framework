import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class LoginTests extends BaseTest {

    @Test(enabled = true, priority = 0, groups = {"Smoke", "Regression"}, description = "Login with valid credentials")
    public void loginValidEmailPassword() {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("test123@test.com").providePassword("te$t$tudent").clickSubmit();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @Test(enabled = true, priority = 1, groups = {"Regression"}, description = "Login with not existing email")
    public void loginNotExistingEmail() {

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.provideEmail("notExistingEmail@test.com").providePassword("te$t$tudent").clickSubmit();
        Assert.assertTrue(loginPage.loginError().isDisplayed());
    }

    @Test(enabled = true, priority = 2, groups = {"Regression"}, description = "Login with Empty Email and Password")
    public void loginWithEmptyEmailPassword() {

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.provideEmail("").providePassword("").clickSubmit();
        Assert.assertTrue(loginPage.emailFieldDisplayed().isDisplayed());
    }

    @Test(enabled = true, priority = 3, groups = {"Regression"}, description = "Login with invalid Password")
    public void loginWithInvalidPassword() {

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.provideEmail("test123@test.com").providePassword("teststudent").clickSubmit();
        Assert.assertTrue(loginPage.loginError().isDisplayed());
    }

    @Test(enabled = true, priority = 4, groups = {"Regression"}, description = "Login with Empty Password")
    public void loginWithEmptyPassword() {

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.provideEmail("test123@test.com").providePassword("").clickSubmit();
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://bbb.testpro.io/");

    }
}
