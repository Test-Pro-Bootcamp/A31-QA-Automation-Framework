import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class launchKoelTest extends BaseTest {

    @Test (enabled = true, priority = 0)
    public void launchKoelTest () {

        //Confirm successful navigation
        WebElement koelLogo = driver.findElement(By.cssSelector("img[alt]"));
    }

//    @Test (enabled = true, priority = 1)
//    public void loginValidUserNameTest () {
//
//        LoginPage loginPage = new LoginPage(getDriver());
//        HomePage homePage = new HomePage(getDriver());
//
//        //Enter tester username
//        loginPage.provideEmail("amandaag39@gmail.com");
//
//        //Enter password
//        loginPage.providePassword("te$t$tudent");
//
//        //Click login button
//        loginPage.clickSubmitBtn();
//
//        //Confirm successful login
//        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
//
//    }

//
//
//    }

}
