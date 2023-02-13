import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;

public class ProfileTests extends BaseTest {

    @Test(enabled = true, priority = 3, description = "LoginValidEmailValidPasswordTest")
    public static void updateProfileNameTest() throws InterruptedException {
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

    @Test(enabled = true, priority = 0, description = "Change profile theme")
    public void changeThere() {
        LoginPage loginPage = new LoginPage(getDriver());
        ProfilePage profilePage = new ProfilePage(getDriver());

        loginPage.logIn();
        clickAvatarIcon();
        //            .clickProfileIcon();
        profilePage.chooseVioletTheme();
         profilePage.isVioletThemeSelected();
    }
}
