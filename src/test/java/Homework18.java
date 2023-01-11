import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Homework18 extends BaseTest {

    @Test
    public static void playSong(){
        //Precondition 1 : Chrome browser
        navigateToPage();
        //Log in with your credentials
        provideEmail("anupapeter@hotmail.com");
        providePassword("te$t$tudent");
        clickSubmit();
        try {Thread.sleep(5000);}
        catch(InterruptedException e){}

        //Goto Songs page
        String url2 = "https://bbb.testpro.io/#!/songs";
        driver.get(url2);
        try {Thread.sleep(3000);}
        catch(InterruptedException e){}

        WebElement song = driver.findElement(By.xpath("//*[@id=\"songsWrapper\"]//td[contains(text(),\"Ketsa\")]"));
        song.click();
        try {Thread.sleep(3000);}
        catch(InterruptedException e){}

        //Click on the play button
        WebElement playNxtbutton1 = driver.findElement(By.xpath("//i[@data-testid=\"play-next-btn\"]"));  //data-testid="play-next-btn"  title="Play next song"
        playNxtbutton1.click();

        /////**** Added this one element after seeing the homework help in the next class, the song was not seen playing without this single element click.
        WebElement playButton1 = driver.findElement(By.xpath("//span[@data-testid=\"play-btn\"]")); //data-testid="play-btn"
        playButton1.click();
        try {Thread.sleep(3000);}
        catch(InterruptedException e){}
        /////*****

        //Check if the web element which is on the bottom of the page contains Song
        WebElement checkSong = driver.findElement(By.xpath("//*[@id=\"progressPane\"]//h3[contains(text(),\"Ketsa\")]"));
        Assert.assertTrue(checkSong.isDisplayed());
        try {Thread.sleep(3000);}
        catch(InterruptedException e){}

        //And also check if the sound bar is displayed
        WebElement equalI = driver.findElement(By.xpath("//*[@id=\"mainFooter\"]//img"));
        Assert.assertTrue(equalI.isDisplayed());
    }
}
