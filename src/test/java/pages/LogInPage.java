package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class LogInPage extends BasePage {
    public LogInPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    @Test
    public void LogInValidEmailTest() {
        LogInPage logInPage = new LogInPage(driver);
        logInPage.provideEmail("skymena75@gmail.com");
        logInPage.providePassword("te$t#tudent");
        logInPage.clickSubmitButton();
        WebElement avatarIcon = driver.findElement(By.cssSelector("[alt='Avatar of student']"));
        assertTrue(avatarIcon.isDisplayed());

    }
}

