package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomPlaylistPage extends BasePage{

    @FindBy (css="button[class='del btn-delete-playlist']")
    WebElement deleteButton;


    public CustomPlaylistPage (WebDriver givenDriver){
        super(givenDriver);
    }

    public CustomPlaylistPage deleteEmptyPlaylist() {
        waitClick(deleteButton);
        deleteButton.click();
        return this;
    }
}
