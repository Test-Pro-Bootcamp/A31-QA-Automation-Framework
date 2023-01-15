import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {
    @Test
    public void LoginValidEmailValidPasswordTest() {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login("hand923@gmail.com", "te$t$tudent");

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
        }

    }
