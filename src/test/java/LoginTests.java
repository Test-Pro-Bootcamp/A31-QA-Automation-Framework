import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test(dataProvider = "IncorrectLoginProvider", dataProviderClass = BaseTest.class)
    public void loginEmptyEmailPasswordTest (String email, String password) {

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.login(email, password);
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }

    @Test
    public void loginValidEmailValidPasswordTest (){

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("demo@class.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmitBtn();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

    }

    @Test
    public void loginInvalidEmailValidPasswordTest() {

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.provideEmail("invalid@class.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmitBtn();

        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }

}
