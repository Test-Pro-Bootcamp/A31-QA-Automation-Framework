import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {

    @Test
    public void deletePlaylist() throws InterruptedException {
        //Login valid credentials
        provideEmail("jrpasia@gmail.com");
        providePassword("B3n@iah2013");
        clickSubmit();

        Thread.sleep(2000);
        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        Assert.assertTrue(avatarIcon.isDisplayed());

        //Navigate to playlist (Work Jams)
        WebElement selectedPlaylist = driver.findElement(By.cssSelector("a[href='#!/playlist/22073']"));
        Actions acts = new Actions(driver);
        acts.contextClick(selectedPlaylist).perform();
        Thread.sleep(5000);

        //Click "Delete" option
        WebElement deleteThePlaylist = driver.findElement(By.cssSelector("[data-testid='playlist-context-menu-delete-22073']"));
        deleteThePlaylist.click();

        //Click "OK" confirmation
        WebElement deleteConfirmation = driver.findElement(By.cssSelector("button[class='ok']"));
        deleteConfirmation.click();
        Thread.sleep(3000);
        String homepage = "https://bbb.testpro.io/#!/home";
        Assert.assertEquals(driver.getCurrentUrl(), url);

    }

}
