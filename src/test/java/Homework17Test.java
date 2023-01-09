import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
    @Test(enabled = false, description = "Log in with Valid User Info")
     public void loginValidEmailPasswordTest(){
            grabUrl();
        provideEmail("skyeman75@gmail.com");
        providePassword("te$t$tudent");
        clickSubmit();


         WebElement avatarIcon = driver.findElement(By.cssSelector("[alt='Avatar of student']"));
         assertTrue(avatarIcon.isDisplayed());
    }
    @Test( enabled = false, description = "Invalid User Email")
    public void loginInvalidEmailPasswordTest(){
       grabUrl();
        String url = grabUrl();
        provideEmail("invalid@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
    @Test(priority = 1, description = "Move a Song to a Play List")
    public void addASong(){
        grabUrl();
        provideEmail("skyeman75@gmail.com");
        providePassword("te$t$tudent");
        clickSubmit();
        WebElement allSongs = driver.findElement(By.cssSelector("a[href='#!/songs']"));
        allSongs.click();
        WebElement selectSong = driver.findElement(By.xpath("//tr[@class='song-item selected']"));
        selectSong.click();
        WebElement playList = driver.findElement(By.cssSelector("a[href='#!/playlist/35821']"));
        Actions act = new Actions(driver);
        act.dragAndDrop(selectSong,playList).build().perform();


    }





}
