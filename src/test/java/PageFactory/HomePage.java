package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    By userAvatarIcon = By.cssSelector("img.avatar");

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public WebElement getUserAvatar() {
        return findElement(userAvatarIcon);
    }


//    click on all songs

    @FindBy(xpath = "//a[.='All Songs']")
            WebElement allSongsField;

    public HomePage ClickAllsongs() {
        click(allSongsField);
        return this;

    }



}
