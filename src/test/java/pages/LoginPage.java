package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    By emailFieldLocator= By.cssSelector("[type='email']");
    By passwordFieldLocator= By.cssSelector("[type='password']");
    By submitButtonLocator= By.cssSelector("button[type='submit']");

    public LoginPage( WebDriver givenDriver) {
        super(givenDriver);
    }
    public void provideEmail(String email){
        driver.findElement(emailFieldLocator).sendKeys(email);
    }
public void providePassword (String password) {
    driver.findElement(passwordFieldLocator).sendKeys(password);
    }
public LoginPage clickSubmitBtn() {
        driver.findElement(submitButtonLocator).click();
        return this;
}
public void login(){
    provideEmail("sandra.geche@gmail.com");
    providePassword("te$t$tudent");
    clickSubmitBtn();
}
}
