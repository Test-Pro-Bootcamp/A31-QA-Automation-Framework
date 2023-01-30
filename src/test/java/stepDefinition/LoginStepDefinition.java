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
    public void iOpenHomepage() {
       iOpenLoginPage();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='email']"))).sendKeys("shalinibaronia@gmail.com");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='password']"))).sendKeys("te$t$tudent");
        iSubmit();

    }

    @When("I context click on song")
    public void iContextClickOnSong() {
        Actions acts = new Actions(driver);
        WebElement song = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ol[@class='top-song-list']//article[@class='playing']//span[@class='details']")));
        acts.contextClick(song).perform();
    }

    @And("I click play button")
    public void iClickPlayButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='playback']"))).click();
    }


    @And("Song is playing")
    public void songIsPlaying() {
        Assert.assertTrue();
    }
}
