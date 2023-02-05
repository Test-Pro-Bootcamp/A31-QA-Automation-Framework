package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProfilePage extends BasePage{
    public ProfilePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    //locators
    By violetTheme = By.xpath("//div[@data-testid='theme-card-violet']");

    By isVioletThemeSelected = By.xpath("//div[@data-testid='theme-card-violet' and contains(@class,'selected')]");

    @FindBy (css=" a.view-profile > img ")
    WebElement avatarIcon;
    public ProfilePage chooseVioletTheme() {
        click(violetTheme);
        return this;
    }
public ProfilePage avatarIconBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(avatarIcon));
        click(avatarIcon);
        return this;
}



    public boolean isVioletThemeSelected(){
//        wait.until(ExpectedConditions.visibilityOf(isVioletThemeSelected));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return driver.findElement(isVioletThemeSelected).isDisplayed();
    }

}