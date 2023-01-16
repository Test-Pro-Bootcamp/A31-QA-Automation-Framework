import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public static String url ="https://bbb.testpro.io/";
    public static WebDriverWait wait = null;
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    @Parameters({"KoelURL"})
    public static void launchBrowser(String KoelUrl){
       driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url=KoelUrl;
        driver.get(url);
     wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @AfterMethod
    public static void closeBrowser(){
        driver.quit();
    }
    public static void login() {
        provideEmail();
        providePassword();
        clickSubmitButton();
    }

    public static void provideEmail() {
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.clear();
        emailField.sendKeys("sandra.geche@gmail.com");
        }
    public static void providePassword() {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordField.clear();
        passwordField.sendKeys("te$t$tudent");
    }
    public static void clickSubmitButton() {
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit"));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit]")));
//        driver.findElement(By.cssSelector("button[type='submit]")).click();
        submitButton.click();
    }
    public static void validateHomepage() {
        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
       Assert.assertTrue(avatarIcon.isDisplayed());
    }
    public static void addPlaylist() {
        WebElement addPlayList = driver.findElement(By.xpath("//*[@class='fa fa-plus-circle create']"));
        wait.until(ExpectedConditions.visibilityOf(addPlayList)).click();
    }
        public static void newPlaylist (){
        WebElement newPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-testid='playlist-context-menu-create-simple']")));
        driver.findElement(By.xpath("//*[@data-testid='playlist-context-menu-create-simple'']")).click();
        }



//    @BeforeMethod
//    @Parameters({"BaseURL"})
//    public static void launchBrowser(String BaseURL) {
//        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        url = BaseURL;
//        driver.get(url);
////        wait = new WebDriverWait(LoginTests.driver, Duration.ofSeconds(20));
//    }
//    @AfterMethod
//    public static void closeBrowser(){
//       driver.quit();
//    }
////    protected static void navigateToPage() {
////        String url = "https://bbb.testpro.io/";
////        driver.get(url);
////    }
//    public static void login(String email, String password) {
//        provideEmail(email);
//        providePassword(password);
//        clickSubmit();
//    }
//    public static void clickSubmit() {
//        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
//        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
//        submitButton.click();
//    }
//    public static void providePassword(String password) {
//        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
//        wait.until(ExpectedConditions.elementToBeClickable(passwordField));// use this when method only take WebElement
//        passwordField.clear();
//        passwordField.sendKeys(password);
//    }
//    public static void provideEmail(String email) {
//        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='email']")));
//        emailField.clear();
//        emailField.sendKeys(email);
//    }
//    public static void clickSaveButton() {
//        WebElement saveButton = driver.findElement(By.cssSelector("button.btn-submit"));
//        saveButton.click();
//    }
//    public static void provideProfileName(String randomName) {
//        WebElement profileName = driver.findElement(By.cssSelector("[name='name']"));
//        profileName.clear();
//        profileName.sendKeys(randomName);
//    }
//    public static void provideCurrentPassword(String password) {
//        WebElement currentPassword = driver.findElement(By.cssSelector("[name='current_password']"));
//        currentPassword.clear();
//        currentPassword.sendKeys(password);
//    }
//    public static String generateRandomName() {
//        return UUID.randomUUID().toString().replace("-", "");//
//    }
//
//    public static void clickAvatarIcon() {
//        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
//        avatarIcon.click();
//    }
//
////    @DataProvider(name="incorrectLoginProviders")
////    public static Object[][] getDataFromDataproviders() {
////
////        return new Object[][]{
////                {"invalid@email.com", "invalidPass"},
////                {"demo@mail.com", "invalid"},
////                {"", ""}
////        };
////    }
}
