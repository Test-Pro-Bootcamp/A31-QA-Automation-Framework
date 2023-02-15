import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProfilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.profiler.model.Profile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BaseTest {
    @Test
    public static void updateProfileNameTest () throws Exception {

        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        loginPage.provideEmail("demo@class.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmitBtn();

        profilePage.clickAvatarIcon();

        String randomName = profilePage.generateRandomName();

        profilePage.provideCurrentPassword("te$t$tudent");
        profilePage.provideProfileName(randomName);
        profilePage.clickSaveButton();

        WebElement actualProfileName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.view-profile>span")));
        Thread.sleep(2000);
        Assert.assertEquals(actualProfileName.getText(), randomName);

    }


}
