import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    //    @Test(enabled = true, priority = 0, description = "LoginEmptyEmailPasswordTest")
    @Test(enabled = true, dataProvider = "incorrectLoginProviders", dataProviderClass = BaseTest.class)
    public static void loginEmptyEmailPasswordTest (String email, String password) {

        login();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    //Page Object Model example
    @Test (enabled = true)
    public void LoginValidEmailPasswordTest () {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("demo@class.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmitBtn();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

    }

    @Test(enabled = true, priority = 2, description = "LoginInvalidEmailValidPasswordTest")
    public static void loginInvalidEmailValidPasswordTest () {

        LoginPage loginPage = new LoginPage(driver);
        //HomePage homePage = new HomePage(driver);

        provideEmail("invalid@class.com");
        providePassword("te$t$tudent");
        loginPage.clickSubmitBtn();

        Assert.assertEquals(driver.getCurrentUrl(), url);

    }



}
