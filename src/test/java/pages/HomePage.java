package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HomePage extends BasePage {

            public HomePage( WebDriver givenDriver) {
                super(givenDriver);
//                driver = givenDriver;//we can remove these ones since we have initialized them in basepage(inheritance using extends)
//                wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        }

//        POM locators
//        By firstPlaylist = By.cssSelector(".playlist:nth-child(3)");
//        By playlistInputField = By.cssSelector("input[name='name']");
//        By userAvatarIcon = By.cssSelector("img.avatar");

//        Page Factory locators
        @FindBy(css = "input[name='name']")
        WebElement playlistInputField;

        @FindBy(css = "img.avatar")
        WebElement userAvatarIcon;



   //     public void doubleClickFirstPlaylist(){
    //        doubleclick = driver.findElement(firstPlaylist);
   //     }
        public void enterPlaylistName(String playlistName) {
            playlistInputField.sendKeys((Keys.chord(Keys.CONTROL,"a",Keys.BACK_SPACE)));
            playlistInputField.sendKeys(playlistName);
            playlistInputField.sendKeys(Keys.ENTER);
        }

        public WebElement getUserAvatar () {
            return userAvatarIcon;
        }
        public boolean doesPlaylistExist(String playlistName){
            WebElement playlistElement = driver.findElement(By.xpath("//a[text()='+playlistName+']"));
            return playlistElement.isDisplayed();
        }
        public boolean isDisplayed(){
            return true;
        }

    }

