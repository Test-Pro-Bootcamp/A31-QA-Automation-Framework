import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProfilePage;

public class ProfileTests extends BaseTestHW24 {


    @Test(enabled = true, priority = 0, description = "Change profile theme")
    public void changeTheme() {
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        loginPage.logIn()
                .clickProfileIcon();
        profilePage.chooseVioletTheme()
                .isVioletThemeSelected();
    }

    @Test(enabled = false, priority = 1, description = "update profile test")
    public void updateProfileNameTest () throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);

        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();

        Thread.sleep(2000);
        clickAvatarIcon();

        String randomName = generateRandomName();

        provideCurrentPassword("te$t$tudent");
        provideProfileName(randomName);
        clickSaveButton();

        Thread.sleep(2000);
        WebElement actualProfileName = driver.findElement(By.cssSelector("a.view-profile>span"));
        Assert.assertEquals(actualProfileName.getText(), randomName);

    }
}
