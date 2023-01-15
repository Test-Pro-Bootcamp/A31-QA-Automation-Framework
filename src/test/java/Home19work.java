import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.naming.Name;
import java.util.UUID;

public class Home19work extends BaseTest{
    @Test
    public void deletePlaylist(){
        login("karkisuman0330@gmail.com","te$t$tudent");

        newPlaylist();
        chknewPlaylist();
        dltplaylist();

    }

    public void  newPlaylist() {
        driver.findElement(By.cssSelector("[data-testid='sidebar-create-playlist-btn']")).click();

        driver.findElement(By.cssSelector("[data-testid='playlist-context-menu-create-simple']")).click();

        WebElement nameList = driver.findElement(By.cssSelector("input[name='name']"));

        nameList.sendKeys("rocksg" + Keys.ENTER);
    }
  public void chknewPlaylist(){
        WebElement rockSngPlaylist =driver.findElement(By.xpath("//*[@id='playlists']/ul/li[3]/a)"));
        Assert.assertEquals(rockSngPlaylist,"rocksg");
    }
    public void dltplaylist(){

    }

}
