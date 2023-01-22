import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

public class CurrentQueTests extends BaseTest {

    @Test
    public void addASongTest() {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        BasePage basePage = new BasePage(driver);
        Actions acts = new Actions(driver);

        //Login valid credentials
        loginPage.login();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

        //Click All Songs link
        homePage.clickAllSongsBtn();

        //Click "Ketsa" song
        WebElement ketsaSong = driver.findElement(By.xpath("//*[@id='songsWrapper']/div/div/div[1]/table/tr[7]/td[2]"));
        ketsaSong.click();
        acts.contextClick(ketsaSong).perform();

        //Click "Add To"
        basePage.findElement(By.xpath("//ul/li[@class='has-sub']")).click();

        //Click "Top of Queue"
        basePage.findElement(By.xpath("//ul/li[@class='has-sub']/ul/li[3]")).click();

        //Assert song is added to que
        homePage.clickCurrentQueBtn();
        basePage.findElement(By.xpath("//*[@id=\"queueWrapper\"]/div/div/div[1]/table/tr/td[2]"));




    }
}
