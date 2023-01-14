import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;



public class Homework18MG extends BaseTest{

    @Test
    public void playSongTest() {
        login("maria868g@gmail.com", "Grishchenko_000");
        playSong();

    }
    public void playSong(){
        WebElement playButton = driver.findElement(By.cssSelector("[title='Play or resume']"));
        playButton.click();
        //Current song is playing

        WebElement nextSongButton = driver.findElement(By.cssSelector("[title='Play next song']"));
        nextSongButton.click();
        //Next song in queue is playing

        WebElement soundVisualizer = driver.findElement(By.cssSelector("[alt='Sound bars'']"));
        Assert.assertTrue(soundVisualizer.isDisplayed());
    }
}
