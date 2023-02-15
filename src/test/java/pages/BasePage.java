package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


      public class BasePage {

        protected WebDriver driver;
        protected WebDriverWait wait;
        protected Actions actions;

        public BasePage( WebDriver givenDriver) {
            driver = givenDriver;
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            actions = new Actions(driver);
            PageFactory.initElements(driver, this);
        }

        public void click(WebElement locator) {
            waitClick(locator);
            actions.click(locator).perform();
        }

        public WebElement findElement(By locator) {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }

        public void contextClick(By locator) {

            actions.contextClick(findElement(locator)).perform();
        }

        public void doubleClick (WebElement  locator) {
            waitClick(locator);
            actions.doubleClick(locator).perform();
        }
          public void waitClick(WebElement locator) {
              wait.until(ExpectedConditions.elementToBeClickable(locator));
          }

    }

