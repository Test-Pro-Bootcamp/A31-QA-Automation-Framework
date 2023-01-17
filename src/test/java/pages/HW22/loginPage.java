package pages.HW22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage extends basePage {


    WebDriver driver;
    WebDriverWait wait;
    //locators
    By submitButtonLocator = By.cssSelector("[type='submit']");
    By emailField = By.cssSelector("[type='email']");
    By passwordField = By.cssSelector("[type='password']");

    public loginPage( WebDriver givenDriver) {
        super(givenDriver);
    }


    public void clickSubmitBtn() {

        driver.findElement(submitButtonLocator).click();
    }

    public void provideEmail(String email) {
        WebElement emailElement = driver.findElement(emailField);
        emailElement.sendKeys(email);
    }

    public void providePassword(String password) {
        WebElement passwordElement = driver.findElement(passwordField);
        passwordElement.sendKeys(password);

    }

    public void logIn(){
        provideEmail("zahinedU@gmail.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
    }

}
