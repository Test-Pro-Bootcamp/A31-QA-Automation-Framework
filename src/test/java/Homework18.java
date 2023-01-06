import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Homework18 extends BaseTest {

    @Test
    public static void playSong () throws InterruptedException {
        navigateToPage();
        Thread.sleep(2000);
        login("terrence.regis@gmail.com", "te$t$tudent");
        Thread.sleep(2000);

        WebElement allSongs = driver.findElement(By.cssSelector("[href='#!/songs']"));
        allSongs.click();
        Thread.sleep(2000);

        Actions act = new Actions(driver);
        WebElement song = driver.findElement(By.xpath("//tr/td[contains(text(), 'Take my Hand - Piano')]"));
        act.doubleClick(song).perform();
        Thread.sleep(5000);

        driver.findElement(By.cssSelector("[class='wrapper']")).isDisplayed();
        Thread.sleep(2000);

    }
}
