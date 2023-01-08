import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18jimmyvu extends BaseTest{

    @Test
    public static void playASongTest() throws InterruptedException{
        login("jimmypvu@gmail.com", "te$t$tudent");
        Thread.sleep(1000);
        playASong();
        Thread.sleep(1000);

    }

    public static void playASong() throws InterruptedException{
        WebElement allSongsPage = driver.findElement(By.xpath("//a[@class='songs']"));
        allSongsPage.click();
        Thread.sleep(1000);

        WebElement song = driver.findElement(By.xpath("//td[@class='title'][contains(text(), 'Waiting On A Train')]"));
        Actions action = new Actions(driver);
        action.doubleClick(song).build().perform();

        WebElement pauseButton = driver.findElement(By.xpath("//span[@data-testid='pause-btn']//i[@class='fa fa-pause']"));
        Assert.assertTrue(pauseButton.isEnabled());

        WebElement soundBar = driver.findElement(By.xpath("//img[@alt='Sound bars']"));
        Assert.assertTrue(soundBar.isDisplayed());
    }
}
