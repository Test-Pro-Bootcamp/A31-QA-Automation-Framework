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
    public void addSongToPlaylist throws InterruptedException() throws InterruptedException {

        //Navigating to Koel
        navigateToPage();

        //Login Method w/ Wait time
        login("mitchelterlecki@gmail.com", "te$t$tudent");
        Thread.sleep(3000);

        //Selecting a song
        selectSong ("Pluto");

        //Grabbing a song action
         grabASong();

        //Notification of adding new song test
        String newSongAddedNotification = "Added 1 Song to";
        clickSubmit();
        searchSong(songTitleKeyword:"Pluto");
        viewAllSearchResults();
        searchSong(songTitleKeyword:"Pluto");
        veiwAllSearchResults();
        selectFirstSongResult();
        clickAddToButton();
        choosePlaylist(playlistName:"Homework 17 Playlist");
        Assert.assertTrue(getNotificationText().contains(newSongAddedNotification));



      //  previously used driver for registration: Assert.assertEquals(driver.getCurrentUrl(), registrationUrl);


    }
}