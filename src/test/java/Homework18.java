import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

    @Test
    public void testPlaySong() {
        provideEmail("kbetestack@gmail.com");
        providePassword("te$t$tudent");

        playSong();
        isSongPlaying();

    }

}
