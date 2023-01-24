package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    //locators
    @FindBy(css = "[type='submit']")
    WebElement submitButtonLocator;
    @FindBy(css = "[type='email']" )
    WebElement emailField;
    @FindBy(css = "[type='password']")
    WebElement passwordField;

    public LoginPage( WebDriver givenDriver) {super(givenDriver);
    }

    public void clickSubmitBtn() {submitButtonLocator.click();
    }

    public void provideEmail(String email) {emailField.sendKeys(email);
    }

    public void providePassword(String password) {passwordField.sendKeys(password);
    }

    public void logIn(){
        provideEmail("prytulan@gmail.com");
        providePassword("28268286nN*");
        clickSubmitBtn();
    }

}
