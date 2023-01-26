package tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import pages.AllSongsPage;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

public class KoelTesting {

    BasePage basePage;
    LoginPage loginPage ;
    HomePage homePage;
    AllSongsPage allSongsPage;
    public WebDriver driver;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeMethod
    @Parameters({"baseURL", "loginEmail", "loginPassword"})
    public void beforeMethod(String baseURL, String loginEmail, String loginPassword)
    {
        driver = new FirefoxDriver();
        basePage = new BasePage(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        allSongsPage = new AllSongsPage(driver);

        goToKoel(baseURL);
        logIntoKoel(loginEmail, loginPassword);
    }

    @AfterMethod
    public void afterMethod()
    {
        driver.quit();
    }

    public void goToKoel(String url)
    {
        driver.manage().window().maximize();
        driver.get(url);
    }

    public void logIntoKoel(String userName, String password)
    {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        loginPage.clickLoginBtn();
    }
}
