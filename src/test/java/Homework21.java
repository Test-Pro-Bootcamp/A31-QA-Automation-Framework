import Pages.LoginPage;
import Pages.SongPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.openqa.selenium.Keys.ENTER;

public class Homework21 extends BaseTest {

    @Test
    public void renamePlaylist(){
        LoginPage loginPage = new LoginPage(driver);
        SongPage songPage = new SongPage(driver);

        loginPage.login("demo@class.com", "te$t$tudent");
        songPage.rightClickPlaylist();

        WebElement clickEdit = driver.findElement(By.xpath("//li[contains(text(), 'Edit')]"));
        clickEdit.click();

        WebElement editField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='name']")));
        editField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        editField.sendKeys("Renamed Playlist Successful");
        editField.sendKeys(ENTER);

        closeBrowser();
    }

}
