import io.qameta.allure.Description;


import org.openqa.selenium.By;
//import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.AuthPage;
import settings.WebDriverSettings;





public class Auth extends WebDriverSettings {


    private By advanced = By.id("details-button");
    private By proceed = By.id("proceed-link");



    @Test
    //@Description("Check that logging in is correct with correct password and username")
    public void firstTest() throws Exception {


        //long startTime = System.nanoTime();


        //StopWatch stopwatch = new StopWatch();
        //stopwatch.start();
        for (int i = 137; i <= 200; i++) {
            System.out.println(i);
            System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
            driver = new EventFiringWebDriver(new ChromeDriver());
            driver.get("https://qa2-lsegxmr.com/mrs");
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, 120);
            AuthPage a = new AuthPage(driver, wait);
            a.logIn(i);

        }



        // Stop the StopWatch
//        double endTime = System.nanoTime();
//
//        double duration = (endTime - startTime);// / 1000000000;
//        System.out.println("Time: " + duration);
//        System.out.println("Time: " + (duration/ 1000000000));


    }
}