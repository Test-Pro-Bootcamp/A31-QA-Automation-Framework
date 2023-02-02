import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.UUID;


public class BaseTestHW25 {
    public WebDriver driver = null;
    public String url = null;
    public WebDriverWait wait = null;
    public Actions actions=null;

    public FluentWait fluentWait = null;

    public ThreadLocal<WebDriver> threadLocal;


    @BeforeSuite
    public void setupClass() {
//        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(@Optional String baseURL) throws MalformedURLException {


        url= baseURL;
        threadLocal = new ThreadLocal<>();
        driver= pickBrowser(System.getProperty("browser"));
        threadLocal.set(driver);

        wait= new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        actions=new Actions(getDriver());
        getDriver().manage().window().maximize();
        getDriver().get(url);


//        baseURL = "https://bbb.testpro.io/";
//        driver = pickBrowser(System.getProperty("browser"));
//
//        threadDriver = new ThreadLocal<>();
//        threadDriver.set(driver);
//
//
//        actions= new Actions(getDriver());
//        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(18));
//        url=baseURL;
//        getDriver().manage().window().maximize();
//        getDriver().get(url);

    }


        public WebDriver getDriver() {
            return threadLocal.get();

        }
        @AfterMethod

        public void tearDownBrowser(){
            getDriver().quit();
            threadLocal.remove();
        }

    public WebDriver pickBrowser(String browser)throws MalformedURLException {

            DesiredCapabilities caps = new DesiredCapabilities();
            String gridURL = "http://192.168.1.6:4444/";

        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();

            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                return driver = new EdgeDriver();


            case "grid-edge":
                caps.setCapability("browserName", "MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);

            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

            case "cloud":
                return lambdaTest();


                default:
                WebDriverManager.chromedriver().setup();
                return driver = new ChromeDriver();


        }
    }

    public WebDriver lambdaTest() throws MalformedURLException {

        String username= "zahinedu";
        String authKey= "7CMJ4DFWS9reyI0sNEseKzILnqNUq75kNQXa0AxQKDx95htOJK";
        String hubURL = "https://hub.lambdatest.com/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("browserVersion", "109.0.5414.120");
        capabilities.setCapability("build", "Selenium 4");
        capabilities.setCapability("name",this.getClass().getName());
        capabilities.setCapability("plugin", "git-testing");



//        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
//        ltOptions.put("user", "khaledoni01");
//        ltOptions.put("accessKey", "Zx0HIXlEJ9ERHjcH9UDCvNXRoiSm2si9VM3L6Dii3SX6W1GPF4");
//        ltOptions.put("build", "Selenium 4");
//        ltOptions.put("name", this.getClass().getName());
//        ltOptions.put("platformName", "Windows 10");
//        ltOptions.put("seCdp", true);
//        ltOptions.put("selenium_version", "4.0.0");
//        capabilities.setCapability("LT:Options", ltOptions);

        return new RemoteWebDriver(new URL(hubURL), capabilities);
    }


//    protected static void navigateToPage() {
//        String url = "https://bbb.testpro.io/";
//        driver.get(url);
//    }

    public void login(String email, String password) {
        provideEmail(email);
        providePassword(password);
        clickSubmit();
    }

    public void clickSubmit() {
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        submitButton.click();
    }

    public void providePassword(String password) {
        WebElement passwordField = getDriver().findElement(By.cssSelector("[type='password']"));
        wait.until(ExpectedConditions.elementToBeClickable(passwordField));// use this when method only take WebElement

        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void provideEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='email']")));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void clickSaveButton() {
        WebElement saveButton = getDriver().findElement(By.cssSelector("button.btn-submit"));
        saveButton.click();
    }

    public void provideProfileName(String randomName) {
        WebElement profileName = getDriver().findElement(By.cssSelector("[name='name']"));
        profileName.clear();
        profileName.sendKeys(randomName);
    }

    public void provideCurrentPassword(String password) {
        WebElement currentPassword = getDriver().findElement(By.cssSelector("[name='current_password']"));
        currentPassword.clear();
        currentPassword.sendKeys(password);
    }

    public String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");//
    }

    public void clickAvatarIcon() {
        WebElement avatarIcon = getDriver().findElement(By.cssSelector("img.avatar"));
        avatarIcon.click();

    }

    @DataProvider(name = "incorrectLoginProviders")
    public static Object[][] getDataFromDataproviders() {

        return new Object[][]{
                {"invalid@email.com", "invalidPass"},
                {"zahinedu@gmail.com", "invalid"},
                {"", ""}
        };
    }
}
