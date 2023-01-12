import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ProfileTests extends BaseTest {

    @Test(enabled = true, priority = 3, description = "updateUserProfileTest")
    public static void updateUserProfileTest() throws InterruptedException {
        navigateToPage();
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();

        Thread.sleep(3000);
        String randomName = generateRandomName();

        openUserProfilePage();
        setName(newName);
       // getUserProfileField();


       // provideProfileName(randomName);
        provideCurrentPassword("te$t$tudent");
        clickSaveButton();
        Thread.sleep(3000);

        //WebElement clickAvatarIcon = driver.findElement(By.cssSelector("ing.avatar"));
        // clickAvatarIcon.click();

        clickAvatarIcon();

        WebElement actualUserProfile = driver.findElement(By.cssSelector("a.view-profile>span"));
        Assert.assertEquals(actualUserProfile.getText(), randomName);


    }


    public static String getUserProfileField() {
        return driver.findElement(By.cssSelector("#inputProfileName")).getAttribute("_value");
    }

}











