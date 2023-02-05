import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

    @Test
    public void playSong() throws InterruptedException {
        navigateToPage();
        login("demo@class.com", "te$t$tudent");

        Actions actions = new Actions(driver);
        WebElement doubleClickSong = driver.findElement(By.xpath("//span[contains(text(), 'Mid-Air Machine')]"));
        actions.doubleClick(doubleClickSong).perform();

        Thread.sleep(2000);

        WebElement visualizer = driver.findElement(By.cssSelector("div>img[alt='Sound bars']"));
        Assert.assertTrue(visualizer.isDisplayed());

        closeBrowser();
    }

}
