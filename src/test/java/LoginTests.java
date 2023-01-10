import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    public static String url = "https://bbb.testpro.io/";
    @Test (enabled = true , priority = 0, description = "LoginEmptyEmailPasswordTest")
        public static void LoginEmptyEmailPasswordTest () throws InterruptedException {

        //****Each one of these methods has been created for a shortcut to include it's designated step
        //****The actual code for each method can be found on the BaseTest

        navigateToPage();
        provideEmail("");
        providePassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
    @Test (enabled = true ,priority = 1, description = "LoginValidEmailValidPasswordTest")
        public static void LoginValidEmailValidPasswordTest () throws InterruptedException {

        navigateToPage();
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        WebElement clickAvatarIcon = driver.findElement(By.cssSelector("ing.avatar"));
            Assert.assertTrue(clickAvatarIcon.isDisplayed());
    }

    @Test (enabled = true ,priority = 2, description = "LoginInvalidEmailValidPasswordTest")
        public static void LoginInvalidEmailValidPasswordTest () throws InterruptedException {

        navigateToPage();
        provideEmail("johndoe@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
    @Test (enabled = true ,priority = 3, description = "UpdateUserProfileTest")
    public static void UpdateUserProfileTest() throws InterruptedException {
        navigateToPage();
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(3000);

       String randomName = generateRandomName();

       provideCurrentPassword("te$t$tudent");
       provideProfileName (randomName);
       clickSaveButton();
       Thread.sleep(3000);

       WebElement clickAvatarIcon = driver.findElement(By.cssSelector("ing.avatar"));
       clickAvatarIcon.click();

       WebElement actualUserProfile = driver.findElement(By.cssSelector("a.view-profile>span"));
       Assert.assertEquals(actualUserProfile.getText(), randomName);

    }

 }
