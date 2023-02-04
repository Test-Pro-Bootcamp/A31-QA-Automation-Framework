import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

    @Test
    public static void addSongToPlaylist(){
        navigateToPage();
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();



        closeBrowser();
    }

}
