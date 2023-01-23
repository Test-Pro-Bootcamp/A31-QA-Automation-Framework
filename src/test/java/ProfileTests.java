import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BaseTest {



    @Test(enabled = true, priority = 3, description = "LoginValidEmailValidPasswordTest")
    public static void updateProfileNameTest () throws InterruptedException {

        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();

        clickAvatarIcon();

        String randomName = generateRandomName();

        provideCurrentPassword("te$t$tudent");
        provideProfileName(randomName);
        clickSaveButton();

        //WebElement actualProfileName = driver.findElement(By.cssSelector("a.view-profile>span"));
        WebElement actualProfileName = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.view-profile>span")));
        Assert.assertEquals(actualProfileName.getText(), randomName);

    }
}
