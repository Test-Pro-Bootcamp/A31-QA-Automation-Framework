package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.LoginPage;

import java.time.Duration;

import static stepDefinition.Hooks.getDriver;

public class LoginStepDefinition {

    private WebDriver driver;
    private WebDriverWait wait;
    private String url = "https://bbb.testpro.io/";

//    @Before
//    public void openBrowser(){
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions co = new ChromeOptions();
//        co.addArguments("--remote-allow-origins=*");
//        co.addArguments("--window-size=1920,1080");
//        co.addArguments("--start-maximized");
////        co.addArguments("--headless");
//        driver = getDriver();
//        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//    }
//
//    @After
//    public void closeBrowser() {
//        driver.quit();
//    }
    @Before("@login")
    public void setDriver(){
        driver = getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(250));
    }

    @And("I open Login Page")
    public void iOpenLoginPage() {
        driver.get(url);
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
        Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img.avatar"))).isDisplayed());
    }

    @Then("I am not logged in")
    public void iAmNotLoggedIn(){
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
}
