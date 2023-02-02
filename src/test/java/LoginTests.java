import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class LoginTests extends BaseTest {
    LoginPage loginPage = new LoginPage(getDriver());
    @Test
    public void LoginValidEmailPasswordTest () {
      
        HomePage homepage = new HomePage(getDriver());

        loginPage.provideEmail("shalinibaronia@gmail.com").providePassword("te$t$tudent").clickSubmit();
        Assert.assertTrue(homepage.getUserAvatar().isDisplayed());
    }

    @Test
    public void loginInvalidEmailValidPasswordTest () {



        loginPage.provideEmail("invalid@class.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmit();

        Assert.assertEquals(getDriver().getCurrentUrl(), url);

    }
}