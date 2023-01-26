package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends KoelTesting{

    @Test (enabled = true, description = "Play a song from the songs tab")
    public void playSong(){
        homePage.clickFromYourMusicPanel("songs");
        homePage.playTheSong("Reactor");
        WebElement soundBars = basePage.checkElement(driver.findElement(By.xpath("//img[@alt='Sound bars']")));
        Assert.assertEquals(soundBars.isDisplayed(), true);
    }
}
