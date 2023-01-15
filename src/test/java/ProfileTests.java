import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProfilePage;

public class ProfileTests extends BaseTest {

    @Test(enabled = true, priority = 3, description = "LoginValidEmailValidPasswordTest")
    public static void updateProfileNameTest () throws InterruptedException {

        ProfilePage profilePage = new ProfilePage(driver);
        HomePage homePage = new HomePage(driver);

        profilePage.provideEmail("demo@class.com");
        profilePage.providePassword("te$t$tudent");
        profilePage.clickSubmitBtn();

        homePage.getUserAvatar();

        String randomName = generateRandomName();

        profilePage.providePassword("te$t$tudent");
        provideProfileName(randomName);
        clickSaveButton();

        WebElement actualProfileName = driver.findElement(By.cssSelector("a.view-profile>span"));
        Assert.assertEquals(actualProfileName.getText(), randomName);

    }
}
