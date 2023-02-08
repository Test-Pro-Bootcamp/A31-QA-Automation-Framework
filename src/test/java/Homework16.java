import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;


public class Homework16 extends BaseTest {
    @FindBy(xpath = "//i[@title='Create a new playlist']")
    WebElement buttonPlus;
    @FindBy(xpath = "//li[text()='New Playlist']")
    WebElement newPlayListBtn;
    @FindBy(xpath = "//input[@name='name']")
    WebElement newPlaylistInputField;



    @Test
    public void createPlaylist(String playlistName) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.logIn();
        buttonPlus.click();
        newPlayListBtn.click();
        checkElement(newPlaylistInputField).sendKeys(playlistName,Keys.ENTER);
    }
    public WebElement checkElement(WebElement element)
    {
        return  wait.until(ExpectedConditions.visibilityOf(element));
    }

}
