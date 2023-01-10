import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {

    @Test
    @Parameters ({"BaseURL", "HomeURL"})
    public static void deletePlaylist () throws InterruptedException {
        launchBrowser("https://bbb.testpro.io/");
        login("prytulan@gmail.com", "28268286nN*");
        clickSubmit();
        getHome("https://bbb.testpro.io/#!/home");
        WebElement myPlaylist = driver.findElement(By.xpath("//*[@href='#!/playlist/35873']"));
        myPlaylist.click();
        WebElement deletePlaylistbutton = driver.findElement(By.xpath("//button[@title='Delete this playlist']"));
        deletePlaylistbutton.click();

        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), url);


    }
}