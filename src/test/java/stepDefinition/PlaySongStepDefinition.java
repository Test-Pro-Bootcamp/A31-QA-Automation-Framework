package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.AllSongsPage;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class PlaySongStepDefinition {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("http://bbb.testpro.io");
    }

    @Before
    public void loginDefault() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmail("hand923@gmail.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmitButton();
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    @Given("I open all songs page")
    public void openAllSongsPage() {
        HomePage homePage = new HomePage(driver);
        homePage.clickAllSongs();
    }

    @When("I select the first song")
    public void selectTheFirstSong() {
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        allSongsPage.selectFirstSong();
    }

    @And("I double click the song")
    public void doubleClickTheSong() {
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        allSongsPage.playSelectedSong();
    }

    @Then("I played a song")
    public void playedASong() {
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        Assert.assertTrue(allSongsPage.isPlaying().isDisplayed());
    }
}
