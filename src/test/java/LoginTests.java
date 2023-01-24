import org.openqa.selenium.By;
 main
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    //    @Test(enabled = true, priority = 0, description = "LoginEmptyEmailPasswordTest")
    @Test(enabled = false, dataProvider = "incorrectLoginProviders", dataProviderClass = BaseTest.class)
    public void loginEmptyEmailPasswordTest (String email, String password) {
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.provideEmail("demo@class.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmitBtn();
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }

    //Page Object Model example
    @Test(enabled = true, priority = 1, description = "Login with Valid Email and Password Test")
    public void LoginValidEmailPasswordTest () {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("demo@class.com")
                .providePassword("te$t$tudent")
                .clickSubmitBtn();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

    }

    @Test(enabled = true, priority = 2, description = "Login with Invalid Email and Valid Password Test")
    public void loginInvalidEmailValidPasswordTest () {
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.provideEmail("invalid@class.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmitBtn();

        Assert.assertEquals(getDriver().getCurrentUrl(), url);

    }


 main
    @Test
    public static void RegistrationLinkNavigationTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);

        WebElement registrationLink = driver.findElement(By.cssSelector("[id='hel']"));
        registrationLink.click();


        WebElement title = driver.findElement(By.cssSelector("[style='padding: 32px 0; text-align: center;']"));
        Assert.assertTrue(title.isDisplayed());

        Thread.sleep(3000);

        driver.quit();


    }

}
