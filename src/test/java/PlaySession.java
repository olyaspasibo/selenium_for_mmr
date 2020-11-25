import io.qameta.allure.Description;


import org.testng.annotations.Test;
import pages.ContentPage;
import pages.LogIn;
import pages.MainPage;
import pages.TestMain;
import settings.WebDriverSettings;


public class PlaySession extends WebDriverSettings {


    @Test
    @Description("Play session")
    public void playSession() throws Exception {

        LogIn pageObject = new LogIn(driver, wait);
        pageObject.logIn("ospasibo", "London1234!");

        MainPage mainPage = new MainPage(driver, wait);

        mainPage.changeStartTime();
        mainPage.searchInstrument("RIO");

        ContentPage contentPage = new ContentPage(driver, wait);
        contentPage.playSession();



    }
}