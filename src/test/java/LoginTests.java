import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {


    @Test(enabled = true, priority = 0, description = "LoginEmptyEmailPasswordTest")
    public void emptyEmailPasswordTest() {

        navigateToPage();
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }

    @Test(enabled = true, priority = 1, description = "LoginValidEmailValidPasswordTest")
    public void validEmailValidPasswordTest () {

        navigateToPage();
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.provideEmail("anupapeter@hotmail.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmitBtn();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

    }

    @Test(enabled = true, priority = 2, description = "LoginInvalidEmailValidPasswordTest")
    public void invalidEmailValidPasswordTest () {

        navigateToPage();
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.provideEmail("invalid@class.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmitBtn();
//
        Assert.assertEquals(getDriver().getCurrentUrl(), url);

    }

    @Test(enabled = true, priority = 3, description = "LoginValidEmailValidPasswordTest")
    public void updateProfileNameTest () {

        navigateToPage();
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.provideEmail("anupapeter@hotmail.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmitBtn();

        clickAvatarIcon();

        String randomName = generateRandomName();
        provideCurrentPassword("te$t$tudent");
        provideProfileName(randomName);
        clickSaveButton();

        try{Thread.sleep(10000);}
        catch(Exception e){};
        WebElement newProfileName = driver.findElement(By.xpath("//*[@id=\"userBadge\"]/a[1]/span[contains(text(),'" + randomName + "')]"));
        Assert.assertTrue(newProfileName.isDisplayed());

    }


}
