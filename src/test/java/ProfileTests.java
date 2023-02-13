import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class ProfileTests extends BaseTest {

    @Test(enabled = true, priority = 3, description = "LoginValidEmailValidPasswordTest")
    public static void updateProfileNameTest () throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());


        String randomName = generateRandomName();
        loginPage.logIn();
        clickSubmit();
        clickAvatarIcon();
        provideCurrentPassword("te$t$tudent");
        provideProfileName(randomName);
        clickSaveButton();
        homePage.getSuccessPopUp();

        WebElement actualProfileName = getDriver().findElement(By.cssSelector("a.view-profile>span"));
        Assert.assertEquals(actualProfileName.getText(), randomName);

    }
}
