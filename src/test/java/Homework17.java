import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        login("adeagle2021@gmail.com", "te$t$tudent");
        Thread.sleep(2000);

        WebElement songTitle = driver.findElement(By.cssSelector("[href=\"#!/artist/10\"]"));
        Actions actions = new Actions(driver);
        actions.contextClick(songTitle).perform();
        Thread.sleep(3000);
        WebElement addToOption = driver.findElement(By.cssSelector("[class=\"has-sub\"]"));
        actions.moveToElement(addToOption).perform();
        Thread.sleep(3000);
        WebElement playSelect = driver.findElement(By.cssSelector("ul [class='menu submenu menu-add-to']  li:nth-child(9)"));
        actions.moveToElement(playSelect).perform();
        playSelect.click();
        Thread.sleep(3000);
        isSongAdded();

    }

}
