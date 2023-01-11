import org.testng.Assert;
import org.testng.annotations.Test;



//1. Create a new file Homework17.java with @Test annotation in IntelliJ IDEA.
//
//        2. Create a test case addSongToPlaylist() using @Test annotations
//        and the helper/reusable methods we created.
//
//        3. Navigate to "https://bbb.testpro.io/".
//
//        4. Log in with your credentials.
//
//        5. Add a song to a playlist.
//
//        6. Validate that there is a song added.
//
//        7. Create a new branch and commit your changes.
//
//        8. Push your code to a remote repository.
//
//        9. Create a pull request.

public class Homework17 extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException {

        String newSongAddedNotification = "Added 1 song into";

        //Navigating to Koel
        navigateToPage();

        //Login Method w/ Wait time
        login("mitchelterlecki@gmail.com", "te$t$tudent");
        Thread.sleep(3000);

        //Searching a song
        searchSong("Pluto");

        //View search results
        viewAllSearchResults();

        //Selecting the first song
        selectFirstSongResult();

        //Clicking the add button
        clickAddToButton();

        //Selecting the playlist
        choosePlaylist("Tekken Soundtrack");

        //Checking if Popup button is present after selection
        Assert.assertTrue(isNotificationPopUpPresent());



    }
}