import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TGHW19 extends BaseTest{


    @Test
    public void DeletePlayList(){
        String playlistName = "Hrenovina11";
        login("tatsianahuryeva@yahoo.com","te$t$tudent");
        //driver.get("https://bbb.testpro.io/#!/home");
       // createPlaylist();
        //deletePlaylist();
        //verify();


    }
    public void createPlaylist(){
        WebElement buttonplus;
        buttonplus = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@title='Create a new playlist']")));
        buttonplus.click();

        WebElement newplaylistbtn;
        newplaylistbtn= driver.findElement(By.xpath("//li[text()='New Playlist']"));
        newplaylistbtn.click();

        WebElement inputname;
        inputname = driver.findElement(By.xpath("//input[@name='name']"));
        inputname.clear();
        inputname.sendKeys("Hrenovina11");
        inputname.sendKeys(Keys.ENTER);

        WebElement Hrebtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Hrenovina11'")));
        Hrebtn.click();


    }
    public void deletePlaylist(){
       WebElement deletePl;
        deletePl = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title=\"Delete this playlist\"]")));
        deletePl.click();

    }
    public void verify() throws InterruptedException {
        Thread.sleep(2000);



        List<WebElement> playlistNames = driver.findElements(By.xpath("//section[@id='playlists']//li/a"));

        for(WebElement p : playlistNames) {
            String name = p.getText();
            if (name.equals("Hrenovina11")) {
                Assert.assertTrue(false);
            }
        }
    }

}
