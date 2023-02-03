import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.LoginPage;
import Pages.ProfilePage;

public class ProfileTest extends BaseTest {


    @Test
    public void changeTheme() {
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        loginPage.login()
                .clickProfileIcon();
        profilePage.chooseVioletTheme()
                .isVioletThemeSelected();
    }

    @Test
    public void updateProfileNameTest () throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("shalinibaronia@gmail.com").providePassword("te$t$tudent").clickSubmit();

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