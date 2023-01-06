import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

@Test
public void  playSong() throws InterruptedException {
    navigateToPage();
    login("guyvanalex4@gmail.com", "teststudent!1");
    allSongs();
    songName();
    playNextBtn();
    playBtn();
    Assert.assertTrue(soundBar().isDisplayed());

}
public void allSongs() throws InterruptedException {
    WebElement allSongs = driver.findElement(By.cssSelector("#sidebar > section.music > ul > li:nth-child(3) > a"));
    Thread.sleep(2000);
    allSongs.click();

}
public void songName() throws InterruptedException {
    WebElement songName = driver.findElement(By.xpath("//section[@id='songsWrapper']/div[1]/div[1]/div[1]/table[1]/tr[1]/td[2]"));
    Thread.sleep(5000);
}
public void playNextBtn() throws InterruptedException {
    WebElement playNextBtn = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
    playNextBtn.click();
    Thread.sleep(2000);
}
public void playBtn() throws InterruptedException {
    WebElement playBtn = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
    playBtn.click();
    Thread.sleep(2000);
}
public WebElement soundBar() {
    return driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
}
}