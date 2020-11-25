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

        //long startTime = System.nanoTime();


        //StopWatch stopwatch = new StopWatch();
        //stopwatch.start();
        //for (int i = 1; i < 200; i++) {
            LogIn pageObject = new LogIn(driver, wait);
            pageObject.logIn(email + Integer.toString(1), password);
        //}
        // Stop the StopWatch
//        double endTime = System.nanoTime();
//
//        double duration = (endTime - startTime);// / 1000000000;
//        System.out.println("Time: " + duration);
//        System.out.println("Time: " + (duration/ 1000000000));


    }
}