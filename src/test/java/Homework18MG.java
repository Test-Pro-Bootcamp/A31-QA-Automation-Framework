import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;



public class Homework18MG extends BaseTest{

    @Test
    public void playSongTest() {
        login("demo@class.com", "te$t$tudent");
        //login("maria868g@gmail.com", "Grishchenko_000");
        clickAllSongsButton();
        selectSong();
        clickButtonPlaySong();
        Assert.assertTrue(playingSongIsDesplayed());

    }
    public void clickAllSongsButton() {
        WebElement allSongsButton = driver.findElement(By.cssSelector("a[href='#!/songs']"));
        allSongsButton.click();
    }

    public void selectSong() {
        WebElement selectedSong = driver.findElement(By.xpath("//*[contains(text(),'Paean')]"));
        selectedSong.click();
    }
    public void clickButtonPlaySong() {
        WebElement buttonPlaySong = driver.findElement(By.xpath("//span[@title='Play or resume']"));
        Actions actions = new Actions(driver);
        actions.click(buttonPlaySong).perform();
    }
    public boolean playingSongIsDesplayed(){
        WebElement songIsPlaing = driver.findElement(By.cssSelector("[data-testid = 'sound-bar-play']"));
        return songIsPlaing.isDisplayed();
    }
    //public void playSong(){
       // WebElement playButton = driver.findElement(By.cssSelector("[title='Play or resume']"));
        //playButton.click();
        //Current song is playing

       // WebElement nextSongButton = driver.findElement(By.cssSelector("[title='Play next song']"));
       // nextSongButton.click();
        //Next song in queue is playing

        //WebElement soundVisualizer = driver.findElement(By.cssSelector("[alt='Sound bars'']"));

        //public boolean playinSongIsDisplayed() {
            //WebElement songIsPlaing = driver.findElement(By.cssSelector("[data-testid = 'sound-bar-play']"));
            //Assert.assertTrue(songIsPlaing.isDisplayed());
        ////}
    }
