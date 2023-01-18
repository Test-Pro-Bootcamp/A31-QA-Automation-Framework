import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTests extends BaseTest{

    @Test
    public static void LoginEmptyEmailPasswordTest () {

//        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        LoginPage loginPage = new LoginPage(driver);

//        String url = "https://bbb.testpro.io/";
//        driver.get(url);
//        Assert.assertEquals(driver.getCurrentUrl(), url);
//        driver.quit();

        loginPage.provideEmail("amandaag39@gmail.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmitBtn();

        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        Assert.assertTrue(avatarIcon.isDisplayed());
    }
}
