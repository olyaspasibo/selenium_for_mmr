package pages;

import io.qameta.allure.Step;
import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;


public class MainPage {
    public static WebDriver driver;
    private WebDriverWait wait;
    public JavascriptExecutor jse = (JavascriptExecutor) driver;


    private String instrument = "RIO";
    private By inputInstrument = By.id("inputTextBox");
    private By inputEvent = By.id("inputElement");

    //Date input
    private By startDate = By.id("inputTextBox");
    private By endDate = By.id("inputElement");


    private By createButton = By.id("createButton");

    public WebElement mainView;
    public WebElement sessionCreator;
    public WebElement entitySearch;
    public WebElement autoCompleteSearch;

    public MainPage(WebDriver driver, WebDriverWait wait) throws Exception {
        this.driver = driver;
        this.wait = wait;

        //some shadow-root hierarchy levels
        this.mainView = goToMainView();
        this.sessionCreator = goToSessionCreator();
        this.entitySearch = goToEntitySearch();
        this.autoCompleteSearch = goToAutoCompleteSearch();
    }


    public String userNameStr = "QA_exp3";
    //public WebElement passWord = driver.findElement(By.id("inputPassword"));
    private By passWord = By.id("inputPassword");
    public String passWordStr = "mit1234!!";
    //public WebElement loginButton =  driver.findElement(By.id("inputLoginButton"));
    private By loginButton = By.id("inputLoginButton");


    @Step("Searching Instrument")
    public void searchInstrument(String instrument_test) throws Exception {
        Thread.sleep(3000);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("mrs-app-component")));
        System.out.println("7");
        this.autoCompleteSearch.findElement(inputInstrument).click();
        this.autoCompleteSearch.findElement(inputInstrument).sendKeys(instrument_test);
        this.sessionCreator.findElement(createButton).click();
    }


    public WebElement goToStartTimeContainer() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement s = sessionCreator.findElement(By.id("fromTime"));
        WebElement example = (WebElement) jse.executeScript("return arguments[0].shadowRoot", s);

        WebElement dateAndTime = example.findElement(By.cssSelector(".date-time-container"));
        WebElement date = example.findElement(By.id("datePicker"));
        WebElement time2 = example.findElement(By.id("timeInput"));
        WebElement time = (WebElement) jse.executeScript("return arguments[0].shadowRoot", time2);

        return time;

    }

    public WebElement goToEndTimeContainer() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement s = sessionCreator.findElement(By.id("toTime"));
        WebElement example = (WebElement) jse.executeScript("return arguments[0].shadowRoot", s);
        WebElement dateAndTime = example.findElement(By.cssSelector(".date-time-container"));
        WebElement date = example.findElement(By.id("datePicker"));
        WebElement time2 = example.findElement(By.id("timeInput"));
        WebElement time = (WebElement) jse.executeScript("return arguments[0].shadowRoot", time2);
        return time;


    }

    public void checkNotificationPopUp() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        Thread.sleep(3000);
        WebElement ex0 = this.mainView.findElement(By.cssSelector("div.mrs-container>div.mrs-app-header>div"));

        WebElement ex = ex0.findElement(By.tagName("m-toast"));
        WebElement popUp = (WebElement) jse.executeScript("return arguments[0].shadowRoot", ex);
        WebElement ex2 = popUp.findElement(By.id("toast"));
        WebElement popUp2 = (WebElement) jse.executeScript("return arguments[0].shadowRoot", ex2);
        //Assert.assertEquals(popUp2.findElement(By.id("label")).getText(), "Start time is equal to the end time.");
        //Assert.assertEquals(popUp2.findElement(By.id("label")).getText(), "No events found for the queried criteria.");


    }

    public WebElement goToMainView() throws Exception {
        Thread.sleep(3000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.tagName("mrs-app-component"));
        WebElement example = (WebElement) jse.executeScript("return arguments[0].shadowRoot", element);
        WebElement element2 = example.findElement(By.tagName("mrs-app-container"));
        WebElement example2 = (WebElement) jse.executeScript("return arguments[0].shadowRoot", element2);
        WebElement element3 = example2.findElement(By.id("ironPages"));
        WebElement example4 = (WebElement) jse.executeScript("return arguments[0].shadowRoot", element3);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mainView")));
        WebElement element4 = example2.findElement(By.id("mainView"));
        WebElement example5 = (WebElement) jse.executeScript("return arguments[0].shadowRoot", element4);
        return example5;

    }

    public WebElement goToSessionCreator() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement element5 = mainView.findElement(By.tagName("session-creator"));
        WebElement example6 = (WebElement) jse.executeScript("return arguments[0].shadowRoot", element5);
        return example6;
    }

    public WebElement goToEntitySearch() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement element6 = sessionCreator.findElement(By.tagName("entity-search"));
        WebElement example7 = (WebElement) jse.executeScript("return arguments[0].shadowRoot", element6);
        return example7;
    }

    public WebElement goToAutoCompleteSearch() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement element7 = entitySearch.findElement(By.tagName("auto-complete-search"));
        WebElement example8 = (WebElement) jse.executeScript("return arguments[0].shadowRoot", element7);
        return example8;

    }

    public void setAttribute(WebElement element, String attName, String attValue) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);",
                element, attName, attValue);
    }

    public void getTimeInputField(WebElement startSearchFrom, String fieldId, String fieldValue) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //WebElement element7 = startSearchFrom.findElement(By.id("fieldId"));
        WebElement element7 = startSearchFrom.findElement(By.id(fieldId));
        this.setAttribute(element7, "value", fieldValue);
//        WebElement example8 = (WebElement) jse.executeScript("return argumen
//        ts[0].shadowRoot", element7);
//        WebElement element8 = example8.findElement(By.id("numberInput"));
//        WebElement example9 = (WebElement) jse.executeScript("return arguments[0].shadowRoot", element8);
        //System.out.println(example8.getAttribute("innerHTML"));


    }

    public void changeStartTime() {
        String hour_example = "00";
        String minute_example = "00";
        String sec_example = "00";
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        WebElement startTime = this.goToStartTimeContainer();

        WebElement endTime = this.goToEndTimeContainer();

        this.getTimeInputField(startTime, "hours", hour_example);
        this.getTimeInputField(startTime, "minutes", minute_example);
        this.getTimeInputField(startTime, "seconds", sec_example);
    }
}
