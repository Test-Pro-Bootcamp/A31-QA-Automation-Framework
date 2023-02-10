import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BaseTest {
    @Test
    public static void updateProfileNameTest () {


        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();

        clickAvatarIcon();

        String randomName = generateRandomName();

        provideCurrentPassword("te$t$tudent");
        provideProfileName(randomName);
        clickSaveButton();

        WebElement actualProfileName = driver.findElement(By.cssSelector("a.view-profile>span"));
        wait.until(ExpectedConditions.visibilityOf(actualProfileName));
        Assert.assertEquals(actualProfileName.getText(), randomName);

    }


}
