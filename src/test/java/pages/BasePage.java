package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class BasePage {
    public  WebDriver driver;
    public WebDriverWait wait;
    public String url;
    Actions action;
    public BasePage(WebDriver givenDriver){
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        action= new Actions(driver);

    }
    public void doubleClickAxn(WebElement locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        action.doubleClick(locator).build().perform();
        PageFactory.initElements(driver,this);
    }
     public WebElement findElement(By locator){
   return  wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
}
}
