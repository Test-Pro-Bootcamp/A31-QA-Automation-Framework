import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    //    @Test(enabled = true, priority = 0, description = "LoginEmptyEmailPasswordTest")
    @Test(dataProvider = "incorrectLoginProviders", dataProviderClass = BaseTest.class)
    public static void loginEmptyEmailPasswordTest (String email, String password) {
        login(email, password);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test(enabled = true, priority = 1, description = "LoginValidEmailValidPasswordTest")
    public static void loginValidEmailValidPasswordTest () throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.logIn();
        homePage.getUserAvatar();

  //      loginPage.provideEmail("tatsianahuryeva@yahoo.com");
  //      loginPage.providePassword("te$t$tudent");
        Thread.sleep(5000);
//        loginPage.clickSubmitBtn();
  //      Thread.sleep(5000);


 //       provideEmail("tatsianahuryeva@yahoo.com");
 //       providePassword("te$t$tudent");
//        clickSubmit();

 //       Thread.sleep(2000);
  //      WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
  //      Assert.assertTrue(avatarIcon.isDisplayed());

    }

    @Test(enabled = true, priority = 2, description = "LoginInvalidEmailValidPasswordTest")
    public static void loginInvalidEmailValidPasswordTest () {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("invalid@class.com")
                .providePassword("te$t$tudent")
                .clickSubmitBtn();

//        Assert.assertEquals(driver.getCurrentUrl(), url);

    }



}
