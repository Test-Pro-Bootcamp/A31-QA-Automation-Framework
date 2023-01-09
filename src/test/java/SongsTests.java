import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SongsTests extends BaseTest {

    @Test public static void playSongTest() throws InterruptedException {

        navigateToPage();

        provideEmail("rykov.rg@gmail.com");
        providePassword("te$t$tudent");
        clickSubmit();

        Thread.sleep(3000);

        WebElement playFirstSong = driver.findElement(By.xpath("//*[@id='homeWrapper']/div/div[1]/section[1]/ol/li[1]/article/span[1]"));
        playFirstSong.click();

        Thread.sleep(2000);

        WebElement visualizer = driver.findElement(By.xpath("//*[@id='mainFooter']/div[2]/div[2]/div/button[1]/div/img"));
        Assert.assertTrue(visualizer.isDisplayed());





    }





}
