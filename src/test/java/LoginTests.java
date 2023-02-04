import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    //    @Test(enabled = true, priority = 0, description = "LoginEmptyEmailPasswordTest")
//    @Test(dataProvider = "incorrectLoginProviders", dataProviderClass = BaseTest.class)
//    public static void loginEmptyEmailPasswordTest (String email, String password) {
//        //login(email, password);
//        LoginPage loginPage = new LoginPage(getDriver());
//        loginPage.provideEmail("demo@class.com");
//        loginPage.providePassword("");
//        loginPage.clickSubmitBtn();
//        //wait.
//        Assert.assertEquals(driver.getCurrentUrl(), url);
//    }

    //Page Object Model example
    @Test
    public void LoginValidEmailPasswordTest () {

        //LoginPage loginPage = new LoginPage(driver);
        //HomePage homePage = new HomePage(driver);
         LoginPage loginPage = new LoginPage(getDriver());
         HomePage homePage = new HomePage(getDriver());
        loginPage.provideEmail("demo@class.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmitBtn();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

   // @Test(enabled = true, description = "LoginInvalidEmailValidPasswordTest")
    @Test
    public  void loginInvalidEmailValidPasswordTest () {
        provideEmail("invalid@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        Assert.assertEquals(driver.getCurrentUrl(), url);

    }



}
