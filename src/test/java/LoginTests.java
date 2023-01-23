import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {
//following  example for using page objects
    @Test(enabled = true, priority = 1, description = "LoginValidEmailValidPasswordTest")

    public void LoginValidEmailPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("demo@class.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmitBtn();

        WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar")));
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

    }



//    //   @Test(enabled = true, priority = 0, description = "LoginEmptyEmailPasswordTest")
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
//        provideEmail("kbetestack@gmail.com");
//        providePassword("te$t$tudent");
//        clickSubmit();
//
//        //Need for this is replaced by addtional to @BeforeMethod
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
