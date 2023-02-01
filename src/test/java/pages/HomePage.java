package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    By userAvatarIcon = By.cssSelector("img.avatar");

    public HomePage( WebDriver givenDriver) {
        super(givenDriver);
    }

    public WebElement getUserAvatar () {
        return findElement(userAvatarIcon);
    }
    public WebElement moveToElement(By bySelector) {
        actions = new Actions(driver);
        WebElement playButton = findElement(bySelector);
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-testid='play-btn']")));
        // WebElement playButton = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
        actions.moveToElement(playButton).perform();
        return  playButton;
    }

}
