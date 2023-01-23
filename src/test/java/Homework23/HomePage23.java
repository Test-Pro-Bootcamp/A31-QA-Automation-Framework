package Homework23;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage23 extends BasePage23 {

    By userAvatarIcon = By.cssSelector("img.avatar");

    public HomePage23( WebDriver givenDriver) {

        super(givenDriver);
    }

    public WebElement getUserAvatar () {
        return findElement(userAvatarIcon);
    }

}
