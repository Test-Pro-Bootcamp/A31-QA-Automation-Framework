import org.openqa.selenium.By;
Homework17
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
 main
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {


Homework17

    @BeforeMethod
    public static void launchBrowser() {
        Homework17.driver = new ChromeDriver();
        Homework17.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public static void closeBrowser () {
        Homework17.driver.quit();
    }

    public static void clickSubmit() {
        //find the submit button
        WebElement submitButton = Homework17.driver.findElement(By.cssSelector("[type='submit']"));
        // click into submit button
        submitButton.click();
    }

    public static void providePassword() {
        //find the password field
        WebElement passwordField = Homework17.driver.findElement(By.cssSelector("[type='password']"));
        // click into password field
        passwordField.click();
        // enter valid password
        passwordField.sendKeys("te$t$tudent");
    }

    public static void provideEmail() {
        WebElement emailField = Homework17.driver.findElement(By.cssSelector("[type='email']"));
        // click into email field
        emailField.click();
        // enter valid email inside the email field
        emailField.sendKeys("sandra.geche@gmail.com");

    //    @Test(enabled = true, priority = 0, description = "LoginEmptyEmailPasswordTest")
    @Test(dataProvider = "incorrectLoginProviders", dataProviderClass = BaseTest.class)
    public static void loginEmptyEmailPasswordTest (String email, String password) {


        login(email, password);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    //Page Object Model example
    @Test
    public void LoginValidEmailPasswordTest () {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("demo@class.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmitBtn();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

    }

    @Test(enabled = true, priority = 2, description = "LoginInvalidEmailValidPasswordTest")
    public static void loginInvalidEmailValidPasswordTest () {

        provideEmail("invalid@class.com");
        providePassword("te$t$tudent");
        clickSubmit();

        Assert.assertEquals(driver.getCurrentUrl(), url);

    }

Homework17
    @Test(enabled = true, priority = 3, description = "LoginValidEmailValidPasswordTest")
    public static void updateProfileNameTest () throws InterruptedException {

        navigateToPage();

        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();

        Thread.sleep(2000);
        clickAvatarIcon();

        String randomName = generateRandomName();

        provideCurrentPassword("te$t$tudent");
        provideProfileName(randomName);
        clickSaveButton();

        Thread.sleep(2000);
        WebElement actualProfileName = driver.findElement(By.cssSelector("a.view-profile>span"));
        Assert.assertEquals(actualProfileName.getText(), randomName);

 main
    }

main


}
