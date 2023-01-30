package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginStepDefinition {

    WebDriver driver;
    WebDriverWait wait;
    Actions action;

    @Before
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @After
    public void iCloseBrowser(){
        driver.quit();
    }


    //Login Success
    @And("I open Login Page")
    public void iOpenLoginPage() {
        driver.get("https://bbb.testpro.io/");
    }

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

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']"))).click();
    }

    @Then("I am logged in")
    public void iAmLoggedIn() {
        Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img.avatar"))).isDisplayed());
    }

     //Login with incorrect password
    @Given("I open Login Page URL")
    public void iOpenLoginPageURL() {
      iOpenLoginPage();
    }

    @When("I enter my email {string}")
    public void iEnterMyEmail(String email) {
       iEnterEmail(email);
    }

    @And("I enter incorrect password {string}")
    public void iEnterIncorrectPassword(String password) {
        iEnterPassword(password);
    }

    @And("I click submit")
    public void iClickSubmit() {
        iSubmit();
    }

    @Then("I am not logged in")
    public void iAmNotLoggedIn() {
        String url= "https://bbb.testpro.io/";
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Given("I open Homepage")
    public void iOpenHomepage(String email, String password) {
       iOpenLoginPage();
       iEnterEmail(email);
       iEnterPassword(password);
       iSubmit();
    }

    @When("I context click on song")
    public void iContextClickOnSong() {
        WebElement song = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > section:nth-child(2) > section:nth-child(2) > div:nth-child(2) > div:nth-child(1) > section:nth-child(1) > ol:nth-child(2) > li:nth-child(1) > article:nth-child(1) > span:nth-child(2) > span:nth-child(1)")));
        action.contextClick(song).perform();
    }

    @And("I click play button")
    public void iClickPlayButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='playback']"))).click();
    }

}
