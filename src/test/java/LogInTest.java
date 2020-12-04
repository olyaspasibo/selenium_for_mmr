import org.openqa.selenium.By;
//import org.testng.annotations.Test;
import org.testng.annotations.Test;
import pages.LogIn;
import settings.WebDriverSettings;



public class LogInTest extends WebDriverSettings {


    private By advanced = By.id("details-button");
    private By proceed = By.id("proceed-link");

    String email = "zQA";
    String password = "London1234!";

    @Test
    //@Description("Check that logging in is correct with correct password and username")
    public void firstTest1() throws Exception {



        for (int i = 1; i < 2; i++) {
            LogIn pageObject = new LogIn(driver, wait);
            pageObject.logIn(email + i, password);
        }



    }
}