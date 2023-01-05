import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class Homework17 extends BaseTest {

    @Test
    public static void addSongToPlayList() throws InterruptedException {
        navigateToPage();
        Thread.sleep(2000);
        provideEmail("terrence.regis@gmail.com");
        Thread.sleep(2000);

        providePassword("te$t$tudent");
        Thread.sleep(2000);
        clickSubmit();
        Thread.sleep(2000);


        WebElement allSongs = driver.findElement(By.cssSelector("[href='#!/songs']"));
        allSongs.click();
        Thread.sleep(2000);

        WebElement song = driver.findElement(By.xpath("//tr/td[contains(text(), 'Take my Hand - Piano')]"));
        song.click();
        Thread.sleep(2000);

        WebElement button = driver.findElement(By.cssSelector("[class='btn-add-to']"));
        button.click();
        Thread.sleep(2000);

        WebElement playListName = driver.findElement(By.xpath("//ul/li[contains(text(), 'Playlist1')]"));
        playListName.click();
        Thread.sleep(5000);

       driver.findElement(By.cssSelector("[class='success show']")).isDisplayed();




    }
}

       


















