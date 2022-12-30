import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {


    @Test(enabled = true, priority = 0, description = "LoginEmptyEmailPasswordTest")
   public static void LoginEmptyEmailPasswordTest () {

      navigateToPage();
     Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test(enabled = true, priority = 1, description = "LoginValidEmailValidPasswordTest")
    public static void LoginValidEmailValidPasswordTest () throws InterruptedException {

        navigateToPage();
        provideEmail("tatsianahuryeva@yahoo.com");
        providePassword("te$t$tudent");
        clickSubmit();

        Thread.sleep(2000);
        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        Assert.assertTrue(avatarIcon.isDisplayed());

    }
     @Test(enabled = true, priority = 0, description = "FindSong")
    public static void FindSong () throws InterruptedException {
           //allsongsbutton();

             WebElement allSongs = driver.findElement(By.cssSelector("#!/songs"));
             allSongs.click();

        // chosensong();
         WebElement song = driver.findElement(By.xpath("//td[text()='Ketsa - That_s a Beat']"));
         song.click();

         Thread.sleep(2000);







         buttonAdd();
         addtoplay();
         checkplaylist();
         WebElement songicon = driver.findElement(By.xpath("//td[text()='Ketsa - That_s a Beat']"));
         Assert.assertTrue(songicon.isDisplayed());



     }


    }



