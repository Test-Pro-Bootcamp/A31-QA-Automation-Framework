import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Homwork19 extends BaseTest {

    @Test
    public static void deletePlaylist() {

        //Log in with your credentials
        provideEmail("anupapeter@hotmail.com");
        providePassword("te$t$tudent");
        clickSubmit();
        try {Thread.sleep(5000);}
        catch(InterruptedException e){}

        //Find playlist
        WebElement playlistItem = driver.findElement(By.xpath("//li/a[contains(text(),'hwk19')]"));
        playlistItem.click();
        try {Thread.sleep(3000);}
        catch(InterruptedException e){}

       //Delete Playlist
        WebElement delPlaylist = driver.findElement(By.xpath("//span/button[@class=\"del btn-delete-playlist\"]"));
        delPlaylist.click();
        try {Thread.sleep(10000);}
        catch(InterruptedException e){}

        //Confirm Delete Playlist
        WebElement confirmDelete = driver.findElement(By.xpath("//button[@class=\"ok\"]"));
        confirmDelete.click();
        try {Thread.sleep(10000);}
        catch(InterruptedException e){}

        //Assert Playlist Delete
        //*[@id="playlists"]/ul/li[5]/a
        String name="";
        List<WebElement> listPlaylist = driver.findElements(By.xpath("//*[@id=\"playlists\"]/li/a"));
        for(WebElement el:listPlaylist) {
            name=el.getText();
            if(name.equals("hwk19")){
                Assert.assertTrue(false);
            }
        }
    }
}
