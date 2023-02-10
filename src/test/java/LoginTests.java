import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {
    @Test(enabled = true,priority = 0,groups = {"Regression"},description = "Login with Invalid email and Invalid password test")
    public void loginInvalidEmailInvalidPasswordTest() {
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.provideEmail("invalid@class.com");
        loginPage.providePassword("teststudent");
        loginPage.clickSubmitBtn();
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }

    @Test(enabled = true,priority = 1,groups = {"Smoke","Regression"},description = "Login with Valid Email and Password Test")
    public void loginValidEmailValidPasswordTest() {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.logIn();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

    }
    @Test(enabled = true,priority = 2,groups = {"Regression"},description = "Login with Invalid Email and Valid Password Test")
    public void loginInvalidEmailValidPasswordTest () {
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.provideEmail("invalid@class.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmitBtn();

        Assert.assertEquals(getDriver().getCurrentUrl(), url);

    }
    @Test(enabled = true,priority = 3,groups = {"Regression"}, description = "Login with valid Email and Invalid Password Test")
    public void loginValidEmailInvalidPasswordTest () {
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.provideEmail("abc@test.com");
        loginPage.providePassword("teststudent");
        loginPage.clickSubmitBtn();

        Assert.assertEquals(getDriver().getCurrentUrl(), url);

    }

}
