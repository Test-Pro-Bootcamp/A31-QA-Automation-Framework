package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;
import java.util.UUID;

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
