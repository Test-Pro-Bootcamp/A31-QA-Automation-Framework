package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProfilePage extends BasePage{
    //locators
    private By violetTheme = By.xpath("//div[@data-testid='theme-card-violet']");
    private By isVioletThemeSelected = By.xpath("//div[@data-testid='theme-card-violet' and contains(@class,'selected')]");

    public ProfilePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public ProfilePage chooseVioletTheme() {
        click(violetTheme);
        return this;
    }
    public boolean isVioletThemeSelected(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return driver.findElement(isVioletThemeSelected).isDisplayed();
    }
}