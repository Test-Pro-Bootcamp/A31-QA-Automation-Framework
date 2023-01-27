package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends KoelTesting{

    @Test (enabled = true, description = "Delete a user created playlist")
    public void deletePlaylist(){
        String playlistName = "Hw19 playlist";
        homePage.createPlaylist(playlistName);
        homePage.deletePlaylist(playlistName);

        WebElement element =null;
        try {
            element = homePage.findElement(By.xpath("//div[contains(text(),'Deleted playlist')]"));      //green popup for playlist rename verification
        }catch (Exception e){}
        finally {
            Assert.assertTrue(element != null);
        }
    }
}
