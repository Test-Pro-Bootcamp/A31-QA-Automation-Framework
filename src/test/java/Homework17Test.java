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
        logIn("skyeman75@gmail.com", "te$t$tudent");

    }
    @Test( enabled = false, description = "Invalid User Email")
    public void loginInvalidEmailPasswordTest(){
       logIn("Invalid@class.com", "te$t$tudent");
       grabUrl();
       String url = grabUrl();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
    @Test(priority = 1, description = "Move a Song to a Play List")
    public void addASong(){
        logIn("skyeman75@gmail.com", "te$t$tudent");
        WebElement allSongs = driver.findElement(By.cssSelector("a[href='#!/songs']"));
        allSongs.click();
        WebElement selectSong = driver.findElement(By.xpath("//tr[@class='song-item selected']"));
        selectSong.click();
        WebElement playList = driver.findElement(By.cssSelector("a[href='#!/playlist/35821']"));
        Actions act = new Actions(driver);
        act.dragAndDrop(selectSong,playList).build().perform();


    }





}
