import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class Homework17Test extends BaseTest {
    @Test(description = "Grab the Log In Page")
    public void loginEmptyEmailPasswordTest() {
        grabUrl();
        String url = grabUrl();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
    @Test(priority = 1, description = "Log in with Valid User Info")
     public void loginValidEmailPasswordTest(){
            grabUrl();
        provideEmail("skyeman75@gmail.com");
        providePassword("te$t$tudent");
        clickSubmit();


         WebElement avatarIcon = driver.findElement(By.cssSelector("[alt='Avatar of student']"));
         assertTrue(avatarIcon.isDisplayed());
    }
    @Test(priority = 2, description = "Invalid User Email")
    public void loginInvalidEmailPasswordTest(){
       grabUrl();
        String url = grabUrl();
        provideEmail("invalid@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }


}
