package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePagePF extends BasePagePF {

    @FindBy(css = ("img.avatar"))
    WebElement userAvatarIcon;

    @FindBy(css = (".playlist:nth-child(3)"))
    WebElement firstPlaylist;

    @FindBy(css = "input[name='name]")
    WebElement playlistInputField;

    public HomePagePF(WebDriver givenDriver) {super(givenDriver);}

    public void doubleClickChoosePlaylist() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        WebElement playlistElement = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        actions.doubleClick(playlistElement).perform();
    }
//    public void enterPlaylistName(String playlistName){
//        WebElement playlistNameTextField = playlistNameTextField.findElement();
//        playlistNameTextField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
//        playlistNameTextField.sendKeys(playlistName);
//        playlistNameTextField.sendKeys(Keys.ENTER);
//    }
}
