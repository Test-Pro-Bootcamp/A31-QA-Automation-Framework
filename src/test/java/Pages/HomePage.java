package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HomePage extends BasePage {

    public HomePage (WebDriver givenDriver){
        super(givenDriver);
    }

    public void getUserAvatar (){
        WebElement avatar = driver.findElement(By.cssSelector("img.avatar"));
        Assert.assertTrue(avatar.isDisplayed());
    }
}