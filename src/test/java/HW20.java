import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.awt.*;
import java.time.Duration;
import java.util.List;

public class HW20 extends BaseTest{

    @Test
    public void DeletePlayList(){
        login("tatsianahuryeva@yahoo.com","te$t$tudent");

        WebElement buttonPlus; 
        buttonPlus=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@title='Create a new playlist']")));
        buttonPlus.click();

        WebElement newPlayListbtn=driver.findElement(By.xpath("//li[text()='New Playlist']"));
        wait.until(ExpectedConditions.visibilityOf(newPlayListbtn));
        newPlayListbtn.click();

        WebElement inputName;
        inputName = driver.findElement(By.xpath("//input[@name='name']"));
        wait.until(ExpectedConditions.visibilityOf(inputName));
        inputName.clear();
        inputName.sendKeys("Tatsiana");
        inputName.sendKeys(Keys.ENTER);

        WebElement newPlaylist; //"//a[text()='Tatsiana'"
        newPlaylist = driver.findElement(By.cssSelector("a[href='#!/playlist/36447']"));
        wait.until(ExpectedConditions.visibilityOf(newPlaylist));
        newPlaylist.click();

        WebElement lastDelete;
        lastDelete =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Delete this playlist']")));
        lastDelete.click();
    }
    }


