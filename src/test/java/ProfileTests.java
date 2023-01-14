import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ProfileTests extends BaseTest {
    @Test(enabled = true, priority = 3, description = "LoginValidEdmailValidPasswordTest")
    public static void updateProfileNameTest () throws InterruptedException {

        navigateToPage();

        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();

        Thread.sleep(2000);
        clickAvatarIcon();

        String randomName = generate.RandomName();

        provideCurrentPassword("te$t$tudent");
        provideProfileName(randomName);
        clickSaveButton();

        Thread.sleep(2000);
        WebElement actualProfileName = driver.findElement(By.cssSelector("a.view-profile>span"));
        Assert.assertEquals(actualProfileName.getTest(), randomName);

    }
}
