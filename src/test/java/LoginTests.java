import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void LoginValidEmailPasswordTest () {

        LoginPage loginPage = new LoginPage(driver);
//        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("jrpasia@gmail.com");
        loginPage.providePassword("B3n@iah2013");
        loginPage.clickSubmitBtn();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

//    @Test(enabled = true, priority = 0, description = "LoginEmptyEmailPasswordTest")
//    @Test(dataProvider = "incorrectLoginProviders", dataProviderClass = BaseTest.class)
//    public static void loginEmptyEmailPasswordTest (String email, String password) {
//
//        login(email, password);
//        Assert.assertEquals(driver.getCurrentUrl(), url);
//    }
//
//    @Test(enabled = true, priority = 1, description = "LoginValidEmailValidPasswordTest")
//    public static void loginValidEmailValidPasswordTest () throws InterruptedException {
//
//
//
//
//        provideEmail("demo@class.com");
//        providePassword("te$t$tudent");
//        clickSubmit();
//
//        Thread.sleep(2000);
//        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
//        Assert.assertTrue(avatarIcon.isDisplayed());
//
//    }
//
//    @Test(enabled = true, priority = 2, description = "LoginInvalidEmailValidPasswordTest")
//    public static void loginInvalidEmailValidPasswordTest () {
//
//        provideEmail("invalid@class.com");
//        providePassword("te$t$tudent");
//        clickSubmit();
//
//        Assert.assertEquals(driver.getCurrentUrl(), url);
//
//    }



}
