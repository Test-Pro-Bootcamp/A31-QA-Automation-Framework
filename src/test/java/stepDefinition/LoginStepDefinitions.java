package stepDefinition;

/*public class LoginStepDefinitions {
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @After
    public void iCloseTheBrowser() {
        driver.quit();
    }

    @Given("I open browser")
    public void iopenbrowser() {
        driver.get("https://bbb.testpro.io");
    }

    @When("I enter email {email}")
    public void iEnterEmail(String email) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmail(email);
    }

    @And("I enter password {password}")
    public void iEnterPassword(String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.providePassword(password);
    }

    @And("I submit")
    public void submit() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSubmitBtn();
    }

    @Then("I am logged in")
    public void userIsLoggedIn() {
        Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img.avatar"))).isDisplayed());
    }

    @Then("I get an error message")
    public void loginErrorMessage() {
        Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".error"))).isDisplayed());
    }

    @Then("I get a message enter email and password")
    public void userGetAMsgEnterEmailPassword() {
        Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='email']"))).isDisplayed());
    }
}

*/

