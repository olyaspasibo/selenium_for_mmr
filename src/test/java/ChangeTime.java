import io.qameta.allure.Description;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LogIn;
import pages.MainPage;
import pages.TestMain;
import settings.WebDriverSettings;


public class ChangeTime extends WebDriverSettings {


    @Test
    //@Description("Change hours at start time field")
    public void checkHours() throws Exception {

        LogIn pageObject = new LogIn(driver, wait);
        pageObject.logIn("ospasibo", "London1234!");
        MainPage mainPage = new MainPage(driver, wait);

        mainPage.changeStartTime();
        mainPage.searchInstrument("RIO");



    }
}


