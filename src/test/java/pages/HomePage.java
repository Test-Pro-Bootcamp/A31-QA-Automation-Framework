package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    String playlistname = "L21Rename";

    By userAvatarIcon = By.cssSelector("img.avatar");
    By firstPlaylist = By.cssSelector(".playlist:nth-child(3)");
    By enterPlaylistName = By.cssSelector("input[name='name']");

    public HomePage( WebDriver givenDriver) {
        super(givenDriver);
    }

    public WebElement getUserAvatar () {return findElement(userAvatarIcon);}
    public void choosePlaylist (){
        doubleClick(firstPlaylist);
    }
    public void contextClickChoosePlaylist() {
      doubleClick(firstPlaylist);
    }
    public void enterPlaylistName (){
        WebElement playlistNameTextField = findElement(enterPlaylistName);
        playlistNameTextField.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.BACK_SPACE));
        playlistNameTextField.sendKeys(playlistname);
        playlistNameTextField.sendKeys(Keys.ENTER);
    }
    public boolean doesPlaylistExist() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='"+playlistname+"']")));
        WebElement playlistElement = driver.findElement(By.xpath("//a[text()='"+playlistname+"']"));
        return playlistElement.isDisplayed();
    }





}
