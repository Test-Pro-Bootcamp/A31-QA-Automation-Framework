import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {


    @Test
    public static void addSongToPlaylist() throws InterruptedException {

        navigateToPage();
        logintoPage();
        selectSong();
       Actions actions = new Actions(driver);
        WebElement songTitle = driver.findElement(By.xpath("//tr[@draggable='true']//td[2]"));
        songTitle.click();
       actions.contextClick(songTitle).perform();
       WebElement addtoBtn = driver.findElement(By.cssSelector("[class='has-sub']"));
       Thread.sleep(2000);
       actions.moveToElement(addtoBtn).perform();
       WebElement playlist = driver.findElement(By.xpath("//ul[@class='menu submenu menu-add-to']/li[7]"));
       playlist.click();
       Thread.sleep(2000);


    }


}
