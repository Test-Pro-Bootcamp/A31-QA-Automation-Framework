package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage extends BasePage{

    //locators

    By violetTheme = By.cssSelector("div.main-scroll-wrap section:nth-child(2) ul.themes:nth-child(2) li:nth-child(2) div.theme > div.name");

    By isVioletThemeSelected = By.xpath("//div[@data-testid='theme-card-violet' and contains(@class,'selected')]");

    public ProfilePage(WebDriver givenDriver) {
        super(givenDriver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public ProfilePage chooseVioletTheme() {
        driver.findElement(violetTheme).click();
        return this;
    }

    public boolean isVioletThemeSelected(){
        return driver.findElement(isVioletThemeSelected).isDisplayed();
    }
}
