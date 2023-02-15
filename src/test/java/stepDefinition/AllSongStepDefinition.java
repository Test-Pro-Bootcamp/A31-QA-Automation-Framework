package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.AllSongPage;
import pages.LoginPage;

import java.time.Duration;

public class AllSongStepDefinition {
    protected WebDriver driver;
    protected WebDriverWait wait;



    @Given("I open AllSong Page")
    public void I_open_AllSong_Page() {
        AllSongPage allSongPage = new AllSongPage(driver);
        allSongPage.chooseAllSongsList();
    }

    @When("I selected first song")
    public void I_selected_first_song() {
        AllSongPage allSongPage = new AllSongPage(driver);
        allSongPage.selectFirstSong();
    }

    @And("I double click the song")
    public void userDoubleClickTheSong() {
        AllSongPage allSongPage = new AllSongPage(driver);
        allSongPage.doubleClickFirstSong();
    }

    @Then("The song should playing")
    public void theSongShouldPlaying() {
        AllSongPage allSongPage = new AllSongPage(driver);
        Assert.assertTrue(allSongPage.songIsPlaying().isDisplayed());
    }
}
