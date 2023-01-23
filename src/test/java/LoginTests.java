import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {
@Test
    public void LoginPageValidEmailPasswordTest(){
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
loginPage.login();
homePage.addPlaylist();
homePage.doubleClickToPlaylist();
//    loginPage.provideEmail("sandra.geche@gmail.com");
//    loginPage.provideEmail("te$t$tudent");
//    loginPage.clickSubmitBtn();
//    WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar")));
//    Assert.assertTrue(avatarIcon.isDisplayed());
}
//    //    @Test(enabled = true, priority = 0, description = "LoginEmptyEmailPasswordTest")
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
