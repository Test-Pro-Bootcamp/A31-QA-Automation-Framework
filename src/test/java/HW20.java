import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HW20 extends BaseTest {

    @Test
    public void DeletePlaylist() throws InterruptedException {
        login("zahinedu@gmail.com", "te$t$tudent");
        clickNewPlaylist();
        createPlayList();
        deletePlaylist();
        playListDeleted();

    }


    public void createPlayList() {


        WebElement newPlayList = driver.findElement(By.cssSelector(".fa-plus-circle"));
        wait.until(ExpectedConditions.visibilityOf(newPlayList));
        newPlayList.click();


        WebElement addNewPlayList = driver.findElement(By.cssSelector("[data-testid='playlist-context-menu-create-simple']"));
        wait.until(ExpectedConditions.visibilityOf(addNewPlayList));
        addNewPlayList.click();


        WebElement namePlayList = driver.findElement(By.xpath("//input[@name='name']"));
        wait.until(ExpectedConditions.visibilityOf(namePlayList));
        namePlayList.click();
        namePlayList.clear();
        namePlayList.sendKeys("Amira's List", Keys.ENTER);


    }

    public void deletePlaylist() {
        WebElement deleteList = driver.findElement(By.xpath("//button[@title='Delete this playlist']"));
        wait.until(ExpectedConditions.visibilityOf(deleteList));
        deleteList.click();
    }


    public void playListDeleted() {
        WebElement noPlayList = driver.findElement(By.xpath("//nav[@id='sidebar']"));
        wait.until(ExpectedConditions.visibilityOf(noPlayList));
        Assert.assertTrue(noPlayList.isDisplayed());
    }

        public void clickNewPlaylist() {
           WebElement clickBtn = driver.findElement(By.xpath("//i[@title='Create a new playlist']"));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@title='Create a new playlist']")));
              clickBtn.click();

        }
        }























