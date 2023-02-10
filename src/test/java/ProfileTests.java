import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;

public class ProfileTests extends BaseTest {

    @Test(enabled = true, priority = 0,groups = {"Smoke","Regression"}, description = "update profile name test")
    public void updateProfileNameTest (){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage= new HomePage(getDriver());
        ProfilePage profilePage= new ProfilePage(getDriver());

        String randomName = profilePage.generateRandomName();
        loginPage.logIn();
        profilePage.clickProfileIcon();
        profilePage.provideCurrentPassword("te$t$tudent");
        profilePage.provideProfileName(randomName);
        profilePage.provideEmailAddress("abc@test.com");
        profilePage.clickSaveButton();
        profilePage.getSuccessPopUp();

        WebElement actualProfileName = getDriver().findElement(By.cssSelector("a.view-profile>span"));
        Assert.assertEquals(actualProfileName.getText(), randomName);

    }

    @Test(enabled = true, priority = 1,groups = {"Smoke","Regression"}, description = "Change profile theme")
    public void changeThemeTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        ProfilePage profilePage = new ProfilePage(getDriver());
        HomePage homePage= new HomePage(getDriver());

        loginPage.logIn();
        profilePage.clickProfileIcon();
        profilePage.chooseVioletTheme();
        profilePage.isVioletThemeSelected();
    }
}
