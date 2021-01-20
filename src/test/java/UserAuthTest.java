import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.AuthPage;
import settings.WebDriverSettings;

//import io.qameta.allure.Description;
import org.openqa.selenium.By;
//import org.testng.annotations.Test;
        import org.testng.annotations.Test;
        import pages.AuthPage;
        import pages.LogIn;
        import settings.WebDriverSettings;



public class UserAuthTest extends WebDriverSettings {

    //Buttons used for establishing 'Advanced' connection in Chrome
    private By advanced = By.id("details-button");
    private By proceed = By.id("proceed-link");

    String email = "zQAA";
    String password = "London1234!";

    @Test
//    @Description("Check that logging in is correct with correct password and username")
    public void test() throws Exception {

        //for each item in the cycle do - login
        for (int i = 18; i < 40; i++) {
            System.out.println(i);
            AuthPage page = new AuthPage(driver, wait);
            //LogIn pageObject = new LogIn(driver, wait);
            //pageObject.logIn(email + i, password);
            page.auth(i);
        }
    }


}
