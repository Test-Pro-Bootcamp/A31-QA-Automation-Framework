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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class LoginStepDefinition {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void openBrowser() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    @And("I open login page")
    public void openLoginPage() {
        driver.get("http://bbb.testpro.io");
    }

    @When("I enter email {string}")
    public void enterEmail(String email) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmail(email);
    }

    @And("I enter password {string}")
    public void enterPassword(String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.providePassword(password);
    }

    @And("I submit")
    public void submit() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSubmitButton();
    }

    @Then("I am logged in")
    public void isLoggedIn() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.userAvatarIcon().isDisplayed());
    }

    @Then("I stay in login page")
    public void failedToLogIn() {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.emailFieldDisplayed().isDisplayed());
    }
}
