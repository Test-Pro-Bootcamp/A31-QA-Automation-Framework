import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ProfileTests extends BaseTest {

    @Test(enabled = true, priority = 3, description = "UpdateUserProfileTest")
    public static void updateUserProfileTest() throws InterruptedException {
        navigateToPage();
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(3000);

        String randomName = generateRandomName();

        provideCurrentPassword("te$t$tudent");
        provideProfileName(randomName);
        clickSaveButton();
        Thread.sleep(3000);

        WebElement clickAvatarIcon = driver.findElement(By.cssSelector("ing.avatar"));
        clickAvatarIcon.click();

        WebElement actualUserProfile = driver.findElement(By.cssSelector("a.view-profile>span"));
        Assert.assertEquals(actualUserProfile.getText(), randomName);


}
}
