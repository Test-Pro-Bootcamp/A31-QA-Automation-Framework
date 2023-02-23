package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class AllSongsPage extends BasePage{
    By addTo = By.xpath("//li[contains(text(),'Add To')]");
    By playNextButton = By.xpath("//i[@data-testid='play-next-btn']");
    By playButton = By.xpath("//span[@data-testid='play-btn']");
    By soundbar = By.xpath("//div[@data-testid='sound-bar-play']");

    public AllSongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void rightClickChosenSong(int songRow){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='mainContent']/section[@id='songsWrapper']//table[1]/tr["+songRow+"]/td[2]")));
       WebElement chosenSong = driver.findElement(By.xpath("//section[@id='mainContent']/section[@id='songsWrapper']//table[1]/tr["+songRow+"]/td[2]"));
        contextClick(chosenSong);
    }

    public void choosePlaylistToAddTo(String playlistName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='menu submenu menu-add-to']/li[contains(text(),'"+playlistName+"')]")));
        WebElement chosenPlaylist = driver.findElement(By.xpath("//ul[@class='menu submenu menu-add-to']/li[contains(text(),'"+playlistName+"')]"));
        click(chosenPlaylist);
    }

    public void clickAddToOption(){
        click(addTo);
    };

    public void playASong() {
        driver.findElement(playNextButton).click();
        click(playButton);
    }
    public void isSongPlaying(){
        WebElement soundbarElement = driver.findElement(soundbar);
        Assert.assertTrue(soundbarElement.isDisplayed());
    }
}

