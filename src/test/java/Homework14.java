import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class Homework14 {

    @Test(enabled = true, description = "Navigate to the registration page")
    public static void navigation() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        String url = "https://bbb.testpro.io/";
        driver.get(url);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSubmitBtn();

        String registrationUrl = "https://bbb.testpro.io/registration.php";
        Assert.assertEquals(driver.getCurrentUrl(), registrationUrl);
        driver.quit();
    }
}