import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.naming.Name;
import java.util.UUID;

public class Home19work extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {
        login("karkisuman0330@gmail.com", "te$t$tudent");
        newPlaylist();
        dltplaylist();
        dltPlaylist1();

        WebElement dltMESS = popUPNot();
       Assert.assertFalse(dltMESS.isDisplayed());

    }

    public void  newPlaylist() throws InterruptedException {
       Thread.sleep(3000);
        driver.findElement(By.cssSelector("[data-testid='sidebar-create-playlist-btn']")).click();

        driver.findElement(By.cssSelector("[data-testid='playlist-context-menu-create-simple']")).click();

        WebElement nameList = driver.findElement(By.cssSelector("input[name='name']"));

        nameList.sendKeys("rocksg",Keys.ENTER);
    }

    public void dltplaylist() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//li/a[text()='rocksg']")).click();
        }
   public void dltPlaylist1() throws InterruptedException {
       Thread.sleep(5000);
        driver.findElement(By.cssSelector(".btn-delete-playlist")).click();

    }
   public WebElement popUPNot(){
        return driver.findElement(By.cssSelector("div.success.show"));
    }
}
