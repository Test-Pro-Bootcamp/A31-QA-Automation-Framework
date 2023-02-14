package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.nl.En;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.LoginPage;

import java.time.Duration;

public class LoginStepDefinition {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @Before
    public void openBrowser(){
        ChromeDriverManager.getInstance().setup();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(120));

    }
    @After
    public void closeBrowser() {

        driver.quit();
    }

    @And("I open Login Page")
    public void iOpenLoginPage() {
        driver.get("http://bbb.testpro.io");

    }

    @When("I enter email {string}")
    public void iEnterEmail(String email) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmail(email);
    }

    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.providePassword(password);
     }

    @And("I submit")
    public void iSubmit() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSubmitBtn();
      }

    @Then("I am logged in")
    public void iAmLoggedIn() {
                Assert.assertTrue(
                wait.until(ExpectedConditions
                        .elementToBeClickable(By.cssSelector("img.avatar"))).isDisplayed());
    }

//    @When("I enter email <username>")
  //  public void iEnterEmailUsername(String username) {
 //       LoginPage loginPage = new LoginPage(driver);
//        loginPage.provideEmail(username);
//    }

 //   @And("I enter password <password>")
 //   public void iEnterPasswordPassword(String password) {
 //       LoginPage loginPage = new LoginPage(driver);
 //       loginPage.providePassword(password);
//    }

    @Then("I get an error message")
    public void iGetAnErrorMessage() {
              Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".error"))).isDisplayed());
    }
    @Then("I get Enter Email and Password")
    public void messageEnterEmailAndPassword(){
        Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='email']"))).isDisplayed());
    }
}
