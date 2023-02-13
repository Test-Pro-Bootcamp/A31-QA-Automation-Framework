import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;

public class ProfileTests extends BaseTest {
    @Test(enabled = true, priority = 0, groups = {"Smoke", "Regression"}, description = "Update the profile name")
    public void updateProfileName() {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        ProfilePage profilePage = new ProfilePage(getDriver());

        loginPage.provideEmail("simplyd2d@gmail.com").providePassword("te$t$tudent").clickSubmit();

        String randomName = profilePage.generateRandomName();

        profilePage.clickProfileIcon();
        profilePage.provideCurrentPassword("te$t$tudent");
        profilePage.provideProfileName(randomName);
        profilePage.clickSaveButton();
        profilePage.getSuccessPopUp();

        WebElement actualProfileName = getDriver().findElement(By.cssSelector("a.view-profile>span"));
        Assert.assertEquals(actualProfileName.getText(), randomName);
    }

    @Test(enabled = true, priority = 1, groups = {"Smoke", "Regression"}, description = "Change the theme")
    public void changeCurrentTheme() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        ProfilePage profilePage = new ProfilePage(getDriver());

        loginPage.provideEmail("simplyd2d@gmail.com").providePassword("te$t$tudent").clickSubmit();

        profilePage.clickProfileIcon();
        profilePage.chooseVioletTheme();
        profilePage.isVioletThemeSelected();
    }
}
