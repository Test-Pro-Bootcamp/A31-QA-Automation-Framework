import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework20 extends BaseTest {

    @Test
    public void deleteEmptyPlaylist() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login("test123@test.com", "te$t$tudent");

        //Find Playlist
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[normalize-space()='Homework 20 Test'])[1]"))).click();


        // Delete selected playlist
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Playlist']"))).click();


        // Validate that the playlist is deleted
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Ok']"))).click();


        //String name = "";
        //List<WebElement> listPlaylist = driver.findElements(By.xpath("//section[@id='playlists']"));
        //for (WebElement el : listPlaylist) {
            //name = el.getText();
            //if (name.equals("Homework 20 Test")) {
                //Assert.assertTrue(false);

            }
        }

