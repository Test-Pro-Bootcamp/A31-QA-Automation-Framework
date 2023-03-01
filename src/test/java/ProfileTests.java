import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProfilePage;

public class ProfileTests extends BaseTest {


    @Test(enabled = true, priority = 0, description = "Change profile theme")
    public void changeTheme() {
        LoginPage loginPage = new LoginPage(getDriver());
        ProfilePage profilePage = new ProfilePage(getDriver());

        loginPage.logIn()
                .clickProfileIcon();
        profilePage.chooseVioletTheme()
                .isVioletThemeSelected();
    }
}
