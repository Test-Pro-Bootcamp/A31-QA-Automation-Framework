package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class ProfilePage extends BasePage {
            //locators
    @FindBy(xpath = "//div[@data-testid='theme-card-violet']")
    WebElement violetTheme;


        By isVioletThemeSelected = By.xpath("//div[@data-testid='theme-card-violet' and contains(@class,'selected')]");

        public ProfilePage(WebDriver givenDriver) {
            super(givenDriver);
        }


        public ProfilePage chooseVioletTheme() {
            waitClick(violetTheme);
            click(violetTheme);
            return this;
        }

        public boolean isVioletThemeSelected(){
            wait.until(ExpectedConditions.visibilityOfElementLocated(isVioletThemeSelected));
            return driver.findElement(isVioletThemeSelected).isDisplayed();

//        wait.until(ExpectedConditions.visibilityOf(isVioletThemeSelected));
 //           try {
 //               Thread.sleep(2000);
//            } catch (InterruptedException e) {
 //               throw new RuntimeException(e);
            }
   //         return driver.findElement(isVioletThemeSelected).isDisplayed();



}
