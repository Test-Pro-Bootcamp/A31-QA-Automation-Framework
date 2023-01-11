import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18CH extends BaseTest{

    @Test
    public void playSongInHomepage() throws InterruptedException {
        login();
        Thread.sleep(2000);
        homePage();
        Thread.sleep(2000);
        mostPlayed();
        Thread.sleep(3000);
        playSong();
        Thread.sleep(2000);
        songIsPlaying();


    }
//    public static void homePage(){
//        WebElement homePage = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
//        homePage.click();
//    }
//    public static void mostPlayed() {
//        WebElement mostPlayed = driver.findElement(By.xpath("//h1[contains(text(),'Most Played')]"));
//        mostPlayed.isDisplayed();
//    }
//    public static void playSong(){
//        WebElement playSong = driver.findElement(By.cssSelector("ol.top-song-list:nth-child(2) li:nth-child(1) article:nth-child(1) > span.cover"));
//        playSong.click();
//    }
}
