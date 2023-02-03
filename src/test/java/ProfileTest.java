import Pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Pages.LoginPage;
import Pages.ProfilePage;

import java.net.MalformedURLException;

public class ProfileTest extends BaseTest {

    @BeforeMethod
    @Parameters({"BaseUrl"})
    public void launchBrowser_main(String BaseUrl) throws MalformedURLException {
        this.launchBrowser(BaseUrl);
    }

    @AfterMethod
    public void closeBrowser_main() {
        this.closeBrowser();
    }
    @Test
    public void changeTheme() {
        LoginPage loginPage = new LoginPage(getDriver());
        ProfilePage profilePage = new ProfilePage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("shalinibaronia@gmail.com").providePassword("te$t$tudent").clickSubmit();
              homePage.getUserAvatar();
        profilePage.chooseVioletTheme()
                .isVioletThemeSelected();
    }

    @Test
    public void updateProfileNameTest () throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.provideEmail("shalinibaronia@gmail.com").providePassword("te$t$tudent").clickSubmit();

        Thread.sleep(2000);
        clickAvatarIcon();

        String randomName = generateRandomName();

        provideCurrentPassword("te$t$tudent");
        provideProfileName(randomName);
        clickSaveButton();

        Thread.sleep(2000);
        WebElement actualProfileName = getDriver().findElement(By.cssSelector("a.view-profile>span"));
        Assert.assertEquals(actualProfileName.getText(), randomName);

    }
}