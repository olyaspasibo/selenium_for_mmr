import io.qameta.allure.Description;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
import pages.LogIn;
import pages.MainPage;
import pages.TestMain;
import settings.WebDriverSettings;
//import io.qameta.allure.Description;

public class InstrumentSearch extends WebDriverSettings {

    /*@DataProvider(name = "SetUpInstrument")
    public static Object[][] InstrumentSetUp() {
        return new Object[][] {
                {"RIO"},
                {"LSE"},
                {"FDL"},
                {"SBID"}};
    }

    @Test(dataProvider = "SetUpInstrument")
    @Description("Search Instrument with Start time equals End Time")
    public void searchInstrumentTest(String instrument_test) throws Exception {

        LogIn pageObject = new LogIn(driver, wait);
        pageObject.logIn();

        MainPage mainPage = new MainPage(driver, wait);
        mainPage.searchInstrument(instrument_test);

        mainPage.checkNotificationPopUp();

    }

    @Test
    @Description("Search Instrument with Start time equals End Time")
    public void searchOneInstrumentTest_t() throws Exception {
        String s = "RIO";

        LogIn pageObject = new LogIn(driver, wait);
        pageObject.logIn();

//        MainPage mainPage = new MainPage(driver, wait);
//        mainPage.searchInstrument(s);

        TestMain mainPage = new TestMain(driver, wait);
        mainPage.searchInstrument(s);

        //mainPage.checkNotificationPopUp();

    }*/
}
