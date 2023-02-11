import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BaseTest {
    @Test
    public static void updateProfileNameTest () throws Exception {


        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();

        clickAvatarIcon();

        String randomName = generateRandomName();

        provideCurrentPassword("te$t$tudent");
        provideProfileName(randomName);
        clickSaveButton();

        WebElement actualProfileName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.view-profile>span")));
        Thread.sleep(2000);
        Assert.assertEquals(actualProfileName.getText(), randomName);

    }


}
