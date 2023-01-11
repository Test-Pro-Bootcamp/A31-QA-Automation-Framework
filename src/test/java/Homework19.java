import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {

    @Test
    public static void deleteEmptyPlayList () throws InterruptedException {
        logIn("dummytest@class.com", "te$t$tudent");
        openPlaylist();
        deletePlaylist();


        Assert.assertTrue(getDeletedPlaylistMsg().isDisplayed());
    }
    public static WebElement getDeletedPlaylistMsg(){
        return driver.findElement(By.cssSelector("div.success.show"));

    }
    public static void openPlaylist() throws InterruptedException {
        WebElement emptyPlaylist = driver.findElement(By.xpath("//li/a[text()='L19' ]"));
        emptyPlaylist.click();
        Thread.sleep(2000);
    }
    private static void deletePlaylist() throws InterruptedException {
        WebElement deletePlaylistButton = driver.findElement(By.cssSelector(".btn-delete-playlist"));
        deletePlaylistButton.click();
        Thread.sleep(5000);
    }
}
