package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class HomePage extends BasePage {

    String playlistName = "Crazy";
    By myPlaylist = By.xpath("//a[normalize-space()='Crazy']");
    By deleteButton = By.xpath("//i[@class='fa fa-times']");


    public HomePage(WebDriver givenDriver) {
        super(givenDriver);

    }

    public HomePage enterPlayList() {
        wait.until(ExpectedConditions.elementToBeClickable(myPlaylist)).click();
        return this;
    }

    public HomePage clickDelete() {
        wait.until(ExpectedConditions.elementToBeClickable(deleteButton)).click();
        return this;
    }
}






