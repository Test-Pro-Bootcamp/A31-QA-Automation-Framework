import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    public static WebDriver driver = null;

    @Test(enabled = false, priority = 0, description = "demo")
    public static void LoginEmptyEmailPasswordTest() {

        navigateToPage();
        Assert.assertEquals(driver.getCurrentUrl(), url);

    }

    @Test(enabled = true, priority = 1)
    public static void LoginValidEmailValidPasswordTest() throws InterruptedException {

       navigateToPage();
       provideEmail("demo@class.com");
       providePassword("te$t$tudent");
       clickSubmit();

       Thread.sleep(2000);

       clickAvatarIcon();
       WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
       Assert.assertTrue(avatarIcon.isDisplayed());
    }

    @Test(enabled = true, priority =2, description = "LoginInvalidEmailValidPassword")
    public static void LoginInvalidEmailValidPasswordTest(){

        navigateToPage();
        provideEmail("invalid@class.com");
        providePassword("te$t$tudent");
        clickSubmit();

        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public static void updateProfileNameTest() throws InterruptedException{
        navigateToPage();
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