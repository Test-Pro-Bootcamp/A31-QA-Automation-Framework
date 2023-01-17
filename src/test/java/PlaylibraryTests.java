import org.testng.annotations.Test;
import pages.HW22.AHplaylistPages;
import pages.HW22.basePage;
import pages.HW22.loginPage;


public class PlaylibraryTests extends BaseTest {

    @Test

    public void PlaylibraryTests() {


        basePage basePage = new basePage(driver);
        loginPage loginPage =new loginPage(driver);
        AHplaylistPages AHplaylistPages = new AHplaylistPages(driver);


        loginPage.provideEmail("zahinedu@gmail.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmitBtn();




        AHplaylistPages.AHplaylistPages();

    }




}
