import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {
    @Test
    public void LoginValidEmailValidPasswordTest() {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("hand923@gmail.com")
                 .providePassword("te$t$tudent")
                 .clickSubmitButton();

        Assert.assertTrue(homePage.userAvatarIcon().isDisplayed());
        }

    }
