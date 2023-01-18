package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    public static WebDriver driver;
    WebDriverWait wait;

    //locators
    By emailFieldLocator = By.cssSelector("[type='email']");
    By passwordFiledLocator = By.cssSelector("[type='password']");
    By loginButtonLocator = By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver givenDriver) { super (givenDriver); }

    public void provideEmail(String email) { driver.findElement(emailFieldLocator).sendKeys(email); }


    @FindBy(css = "[test]")
    WebElement email;

    public void providePassword(String password) { driver.findElement(passwordFiledLocator).sendKeys(password); }

    public LoginPage clickSubmitBtn(){
        driver.findElement(loginButtonLocator).click();
        return this;
    }
    public void login() {
        provideEmail("amandaag39@gmail.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
    }

}
