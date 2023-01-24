import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {

    @Test
    public void deleteEmptyPlaylist() throws InterruptedException {
        login("simplyd2d@gmail.com", "te$t$tudent");
        clickSubmit();

        //select playlist Homework 19 Test
        WebElement selectPlaylist = driver.findElement(By.xpath("(//a[normalize-space()='Homework 19 Test'])[1]"));
        selectPlaylist.click();

        //WebDriverWait wait = new WebDriverWait(WebDriverReference,TimeOut);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "locator")));


        // Delete selected playlist
        WebElement deletePlaylist = driver.findElement(By.xpath("//button[normalize-space()='Playlist']"));
        deletePlaylist.click();
        Thread.sleep(3000);

        // Validate that the playlist is deleted
        WebElement deleteMsg = driver.findElement(By.xpath(" //div[@class='success show']"));
        Assert.assertTrue(deleteMsg.isDisplayed());
        Thread.sleep(3000);

    }


    }


