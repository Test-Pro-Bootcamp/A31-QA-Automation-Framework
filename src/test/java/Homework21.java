import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest{
String playListName= "Ali";
@Test
    public void renamePlaylist() throws InterruptedException {
        login("adeagle2021@gmail.com", "te$t$tudent");
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='name']")));
        rightClickPlaylistNam();
        clickEditOption();
        typeNewName();
}
}

