package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage extends BasePage{

    public ProfilePage(WebDriver givenDriver){
        super(givenDriver);
    }
    public void provideEmail(String email) {
        WebElement emailElement = driver.findElement(emailField);
        emailElement.click();
        emailElement.sendKeys(email);
    }

    public void providePassword(String password) {
        WebElement passwordElement = driver.findElement(passwordField);
        passwordElement.click();
        passwordElement.sendKeys(password);
    }

    public void clickSubmitBtn() {
        driver.findElement(submitButtonLocator).click();
    }
}
