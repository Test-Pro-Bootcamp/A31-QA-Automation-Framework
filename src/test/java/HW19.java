import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HW19 extends BaseTest {
    @Test
    public void DeletePlaylist()throws InterruptedException {
        login("zahinedu@gmail.com", "te$t$tudent");
        Thread.sleep(3000);
        createPlayList();
        Thread.sleep(2000);
        deletePlaylist();
        Thread.sleep(2000);
        playListDeleted();
        Thread.sleep(2000);
    }


        public void createPlayList() {


            WebElement newPlayList  = driver.findElement(By.cssSelector(".fa-plus-circle"));
            newPlayList.click();


            WebElement addNewPlayList = driver.findElement(By.cssSelector("[data-testid='playlist-context-menu-create-simple']"));
            addNewPlayList.click();


            WebElement namePlayList = driver.findElement(By.xpath("//input[@name='name']"));
            namePlayList.click();
            namePlayList.sendKeys("AAH Favo.List", Keys.ENTER);


        }

        public void deletePlaylist() {
            WebElement deleteList = driver.findElement(By.xpath("//button[@class='del btn-delete-playlist']"));
            deleteList.click();
        }


            public void playListDeleted() {
                WebElement noPlayList = driver.findElement(By.xpath("//nav[@id='sidebar']"));
                Assert.assertTrue(noPlayList.isDisplayed());


            }


    }





