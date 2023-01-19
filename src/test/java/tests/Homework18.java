package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends KoelTesting{

    @Test
    public void playSong(){
        homePage.clickTabInYourMusic("songs");
        homePage.playTheSong("Reactor");
        WebElement soundBars = basePage.checkElement(By.xpath("//img[@alt='Sound bars']"));
        Assert.assertEquals(soundBars.isDisplayed(), true);
    }
}
