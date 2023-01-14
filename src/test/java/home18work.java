import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import javax.swing.*;

public class home18work  extends BaseTest{

    @Test
public void playaSong()  {
        login("karkisuman0330@gmail.com","te$t$tudent");
        allSong();
        choose();
       equilizerDisplayed();
    }
        public void allSong() {
            WebElement aSongBtn = driver.findElement(By.xpath("//a[@class=\"songs\"]"));
            aSongBtn.click();

    }
       public static void choose() {
        WebElement songName = driver.findElement(By.xpath("//section[@id=\"songsWrapper\"]//tr[3]"));
        songName.click();
        // i try doubleclick its not working comment plz
           //Actions try1 =new Actions(driver);
           //try1.doubleClick(songName);
           WebElement playNextButton = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        WebElement playButton = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        playNextButton.click();
        playButton.click();


    }



    public void equilizerDisplayed() {
        WebElement soundbar = driver.findElement(By.xpath("//div[@data-testid=\"sound-bar-play\"]"));
        Assert.assertTrue(soundbar.isDisplayed());
    }
}

