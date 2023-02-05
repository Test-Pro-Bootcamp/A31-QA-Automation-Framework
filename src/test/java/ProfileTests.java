import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProfilePage;

public class ProfileTests extends BaseTest {
@Test
public void differentBackground() throws InterruptedException {
    LoginPage loginPage = new LoginPage(getDriver());
    ProfilePage profilepage = new ProfilePage(getDriver());
    loginPage.login();
    Thread.sleep(2000);
    profilepage.avatarIconBtn();
    profilepage.chooseVioletTheme();
}
}