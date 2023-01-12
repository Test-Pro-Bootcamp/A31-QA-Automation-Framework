import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.UUID;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;


public class BaseTest {
        public static WebDriver driver = null;
        public static String url = "https://bbb.testpro.io/";

        @BeforeSuite
        static void setupClass() { WebDriverManager.chromedriver().setup();}

    public static void avatarIcon() {
        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        avatarIcon.click();
    }

    @BeforeMethod
        @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) {
        LoginTests.driver = new ChromeDriver();
        LoginTests.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            url = BaseURL;
            driver.get(url);
        }
        public static void navigateToPage() {
            String url = "https://bbb.testpro.io/";
            driver.get(url);
        }
        @AfterMethod   //Quiting the driver after every method
        public static void closeBrowser () {
            LoginTests.driver.quit();
        }
            public static void clickSubmit() {
                WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
                submitButton.click();
            }
            public static void providePassword(String password) {
                WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
                passwordField.clear();
                passwordField.sendKeys(password);
            }
            public static void provideEmail(String email) {
                WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
                emailField.clear();
                emailField.sendKeys(email);
            }
            public static void setName(String newName){
            WebElement sn = driver.findElement(By.cssSelector("#inputProfileName"));
            sn.click();
            sn.clear();
            sn.sendKeys(newName);
            }

            public static void clickSaveButton() {
                WebElement saveButton = driver.findElement(By.cssSelector("button.btn-submit"));
                saveButton.click();
            }
            public static void openUserProfilePage(){
            WebElement profileIcon = driver.findElement(By.cssSelector("#userBadge span.name"));
            profileIcon.click();

            }

            public static void provideCurrentPassword(String password) {
                WebElement currentPassword = driver.findElement(By.cssSelector("[name='current_password"));
                currentPassword.clear();
                currentPassword.sendKeys(password);
            }

            public static String generateRandomName() {
                return UUID.randomUUID().toString().replace("-" , "");

            }
            public static void login(String email,String password) {
                provideEmail(email);
                providePassword(password);
                clickSubmit();
            }

    //Methods below used for Homework17 class - ******disregard********
//            public static void searchSong (String songTitleKeyword) throws InterruptedException {
//                WebElement searchField = driver.findElement(By.cssSelector("div#searchForm-input[type=search]"));
//                searchField.sendKeys(songTitleKeyword);
//                Thread.sleep(4000);
//            }
//
//            public static void viewAllSearchResults() throws InterruptedException {
//                WebElement viewAllSearchResults = driver.findElement(By.cssSelector("div.results-section.songs-h1-button"));
//                viewAllSearchResults.click();
//                Thread.sleep(4000);
//            }
//
//            public static void selectFirstSongResult() throws InterruptedException {
//                WebElement selectFirstSongResult = driver.findElement(By.cssSelector("section#songResultsWrapper-tr.song-item-td.title"));
//                selectFirstSongResult.click();
//                Thread.sleep(4000);
//            }
//
//            public static void clickAddToButton() throws InterruptedException {
//                WebElement addTo = driver.findElement(By.cssSelector("button.btn-add-to"));
//                addTo.click();
//                Thread.sleep(4000);

//            }
//            public static void grabASong() {
//                WebElement song = driver.findElement(By.xpath("//article[@data-test='song-card']")));
//                WebElement playlist = driver.findElement(By.xpath("//li/a[contains(@href,'#!/playlist/35439'"));
//
//                Actions acts = new Actions(driver);
//                acts.clickAndHold(song).moveToElement(playlist).release(playlist).build().perform();
//            }

}
