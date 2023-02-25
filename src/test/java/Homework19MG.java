import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class Homework19MG extends BaseTest{
    @Test

    @Parameters({"BaseURL"})
    public void deletePlayListTest() {
        login("demo@class.com", "te$t$tudent");
        deletePlaylist();
    }

        public void deletePlaylist() {
            WebElement testHW19 = driver.findElement(By.cssSelector("[href='#!/playlist/38670']"));
            testHW19.click();

            Actions action = new Actions(driver);
            WebElement deleteButton = driver.findElement(By.cssSelector("[data-testid='playlist-context-menu-delete-38670']"));
            action.contextClick(deleteButton).perform();

            List<WebElement> playlistSongs = driver.findElements(By.xpath("//section[@id='playlists']//li/a"));

            for (WebElement p : playlistSongs) {
                String name = p.getText();
                if (name.equals(playlistSongs)) {
                    Assert.assertTrue(false);
                }
            }
        }

    }

