import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BaseTest {

    @Test(enabled = true, priority = 3, description = "LoginValidEmailValidPasswordTest")
    public static void updateProfileNameTest () throws InterruptedException {

        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();

        //Thread.sleep(2000);
        clickAvatarIcon();

        String randomName = generateRandomName();
        //what's wrong with this one? locator seems correct
        //seems like it is pointing to a wrong locator, but running a passed test should remove that underline
        provideCurrentPassword("te$t$tudent");
        provideProfileName(randomName);
        clickSaveButton();


        //looks good now
        WebElement actualProfileName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.view-profile>span")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".success.show")));
        Assert.assertEquals(actualProfileName.getText(), randomName);

    }
}
