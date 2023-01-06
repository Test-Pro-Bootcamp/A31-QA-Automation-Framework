import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    static String url = "https://bbb.testpro.io/";

    @Test
    public static void LoginEmptyEmailPasswordTest () {


        launchBrowser();

        navigateToPage();
        Assert.assertEquals(driver.getCurrentUrl(), url);

    }
    @Test
    public static void LoginValidEmailValidPasswordTest(){
        navigateToPage();

        provideEmail("ghoulishgirl@hotmail.com");
        providePassword("te$t$tudent");
        clickSubmit();

        WebElement avatarIcon =driver.findElement(By.cssSelector("[alt = 'Avatar of student']"));
        Assert.assertTrue(avatarIcon.isDisplayed());

    }
    @Test
    public static void LoginInvalidEmailValidPassword()throws InterruptedException {
        navigateToPage();


        provideEmail("ghoulishgirllllll@hotmail.com");
        providePassword("te$t$tudent");
        clickSubmit();

        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), url);


    }


}
