package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomPlaylistPage extends BasePage{

    By deleteButton = By.cssSelector("button[class='del btn-delete-playlist']");
    By successMsg = By.cssSelector("div.success.show");

    public CustomPlaylistPage (WebDriver givenDriver){
        super(givenDriver);
    }

    public void deleteEmptyPlaylist() {
        click(deleteButton);
    }

    public boolean isDeleted() {
        return waitVisible(successMsg);
    }
}
