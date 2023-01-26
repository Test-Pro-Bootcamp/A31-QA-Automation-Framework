package tests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends KoelTesting{

    @Test   (enabled = true, description = "Log into koel")
    public void LoginEmptyEmailPasswordTest ()
    {
        String expectedURL = "https://bbb.testpro.io/#!/home";
        Assert.assertTrue(basePage.checkURl(expectedURL));
    }
}
