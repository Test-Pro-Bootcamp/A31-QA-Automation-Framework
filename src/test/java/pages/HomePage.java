package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage extends BasePage {

    static WebDriver driver;
    WebDriverWait wait;
    By userAvatarIcon = By.cssSelector("img.avatar");


    public HomePage(WebDriver givenDriver) {
        super(givenDriver);

    }

    public HomePage getUserAvatar() {
        driver.findElement(By.xpath("//span[@id='userBadge']"));
        return this;

    }

}

