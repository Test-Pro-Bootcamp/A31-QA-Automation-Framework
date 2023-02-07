import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {
    @Test (groups = {"smoke", "regression"})
    public void LoginValidEmailValidPasswordTest() {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("hand923@gmail.com")
                 .providePassword("te$t$tudent")
                 .clickSubmitButton();

        Assert.assertTrue(homePage.userAvatarIcon().isDisplayed());
        }

    @Test (groups = {"regression"})
    public void LoginValidEmailInvalidPasswordTest() {

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.provideEmail("hand923@gmail.com")
                .providePassword("invalidPW")
                .clickSubmitButton();

        Assert.assertTrue(loginPage.emailFieldDisplayed().isDisplayed());
    }

    @Test (groups = {"regression"})
    public void LoginInvalidEmailValidPasswordTest() {

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.provideEmail("invalidemail@gmail.com")
                .providePassword("te$t$tudent")
                .clickSubmitButton();

        Assert.assertTrue(loginPage.emailFieldDisplayed().isDisplayed());
    }

    @Test (groups = {"regression"})
    public void LoginEmptyEmailEmptyPasswordTest() {

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.provideEmail("")
                .providePassword("")
                .clickSubmitButton();

        Assert.assertTrue(loginPage.emailFieldDisplayed().isDisplayed());
    }
    }
