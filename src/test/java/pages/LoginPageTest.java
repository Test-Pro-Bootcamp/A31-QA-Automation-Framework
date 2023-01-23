package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BasePageTest {

    By submitButtonLocator = By.cssSelector("[type='submit']");
    By emailFieldLocator = By.cssSelector("[type='email']");
    By passwordFieldLocator = By.cssSelector("[type='password']");

    public LoginPageTest(WebDriver givenDriver) {
       super (givenDriver);
    }

    public void clickSubmitButton() {
        driver.findElement(submitButtonLocator).click();
    }

    public void provideEmail(String email) {
        WebElement emailElement = driver.findElement(emailFieldLocator);
        emailElement.click();
        emailElement.sendKeys(email);
    }

    public void providePassword(String password) {
        WebElement passwordElement = driver.findElement(passwordFieldLocator);
        passwordElement.click();
        passwordElement.sendKeys(password);
    }
    public void logIn(){
        provideEmail("skyeman75@gmail.com");
        providePassword("te$t$tudent");
        clickSubmitButton();
    }


    @Test
    public void loginValidEMailPasswordTest() {
    LoginPageTest loginPage = new LoginPageTest(driver);
    HomePageTest homePage = new HomePageTest(driver);
    loginPage.logIn();
    Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
}
