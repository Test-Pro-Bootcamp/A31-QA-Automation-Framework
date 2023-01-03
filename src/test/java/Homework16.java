import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework16 extends BaseTest {

    @Test(enabled = true, description = "Testregistrationlink")
    public static void Registration() {


        WebElement registrationLink = driver.findElement(By.cssSelector("[id='hel']"));
        registrationLink.click();
        String registrationURL = "https://bbb.testpro.io/registration.php";
        Assert.assertEquals(driver.getCurrentUrl(), registrationURL);

    }

@Test(enabled = true, description = "Loginwvalidaccount")
    public static void validLogin (){

        navigateToPage();
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();

        WebElement avataricon = driver.findElement(By.cssSelector("img.avatar"));

        Assert.assertTrue(avataricon.isDisplayed());

}

}
