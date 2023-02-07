import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {
    @Test (priority = 0) //smoke test
    public void LoginValidEmailValidPasswordTest() {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("hand923@gmail.com")
                 .providePassword("te$t$tudent")
                 .clickSubmitButton();

        Assert.assertTrue(homePage.userAvatarIcon().isDisplayed());
        }

    @Test (priority = 1)
    public void LoginValidEmailInvalidPasswordTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("hand923@gmail.com")
                .providePassword("invalidPW")
                .clickSubmitButton();

        Assert.assertTrue(loginPage.emailFieldDisplayed().isDisplayed());
    }

    @Test (priority = 2)
    public void LoginInvalidEmailValidPasswordTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("invalidemail@gmail.com")
                .providePassword("te$t$tudent")
                .clickSubmitButton();

        Assert.assertTrue(loginPage.emailFieldDisplayed().isDisplayed());
    }

    @Test (priority = 3)
    public void LoginEmptyEmailEmptyPasswordTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("")
                .providePassword("")
                .clickSubmitButton();

        Assert.assertTrue(loginPage.emailFieldDisplayed().isDisplayed());
    }
    }
