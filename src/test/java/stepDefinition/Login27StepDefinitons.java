/*package stepDefinition;

/*import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
*/

/*
import java.time.Duration;

public class Login27StepDefinitons {
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void iOpenBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //@Given("I open browser")
    //public void iOpenBrowser() {WebDriverManager.chromedriver().setup();
        //driver = new ChromeDriver();
       // wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    //}

    @After
    public void closeBrowser() {
        driver.quit();
    }

    //@Given("I open Login Page")
    //public void iOpenLoginPage() {
        //driver.get("https://bbb.testpro.io");
    //}


    @When("I enter email {string}")
    public void iEnterEmail(String email) {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='email']"))).sendKeys(email);
    }

    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='password']"))).sendKeys(password);
    }

    @And("I submit")
    public void iSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='submit']"))).click();
    }

    @Then("I am logged in")
    public void IAmLoggedIn() {
        Assert.assertTrue(
                wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img.avatar"))).isDisplayed());
    }

    @When("I enter email \"email'")
    public void iEnterEmailEmail() throws Throwable {    // Write code here that turns the phrase above into concrete actions    throw new cucumber.api.PendingException();}
    }
}
*/