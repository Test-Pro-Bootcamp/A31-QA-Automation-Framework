package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
            wait.until(ExpectedConditions.visibilityOf(userAvatarIcon));
            return userAvatarIcon;
        }
        public boolean doesPlaylistExist(String playlistName){
            WebElement playlistElement = driver.findElement(By.xpath("//a[text()='+playlistName+']"));
            return playlistElement.isDisplayed();
        }
        public boolean isDisplayed(){
            return true;
        }

    public void choosePlaylist() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
    }
    public void conTextClick() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        WebElement element= driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        Actions action = new Actions(driver);
        action.contextClick(element).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[data-testid^='playlist-context-menu-edit']"))).click();
    }
    public void newName() {
        WebElement inputNewName = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='name']")));
        inputNewName.sendKeys((Keys.chord(Keys.CONTROL,"a",Keys.BACK_SPACE)));
        String newPlayListName = "Tatsiana";
        inputNewName.sendKeys(newPlayListName);
        inputNewName.sendKeys(Keys.ENTER);

    }
    public boolean checkPlayList (){
        String newPlayListName = "Tatsiana";
        WebElement createdPlayList = driver.findElement(By.xpath("//a[text()='"+newPlayListName+"']"));
        return createdPlayList.isDisplayed();
    }

    }

