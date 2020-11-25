package pages;


//import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.DataProvider;

public class TestMain  {
    public static WebDriver driver;
    private WebDriverWait wait;
    JavascriptExecutor jse = (JavascriptExecutor) driver;



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

    public TestMain (WebDriver driver, WebDriverWait wait) throws Exception {
        this.driver = driver;
        this.wait = wait;
        System.out.println("suc");

    }



    public String userNameStr = "QA_exp3";
    //public WebElement passWord = driver.findElement(By.id("inputPassword"));
    private By passWord = By.id("inputPassword");
    public String passWordStr = "mit1234!!";
    //public WebElement loginButton =  driver.findElement(By.id("inputLoginButton"));
    private By loginButton =  By.id("inputLoginButton");



    //@Step("Searching Instrument")
    public void searchInstrument(String instrument_test) throws Exception {
        Thread.sleep(3000);
        System.out.println("1");
        System.out.println(driver.getPageSource());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("mrs-app-component")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.tagName("mrs-app-component"));
        WebElement example = (WebElement) jse.executeScript("return arguments[0].shadowRoot", element) ;

        WebElement element2 = example.findElement(By.tagName("mrs-app-container"));
        WebElement example2 = (WebElement) jse.executeScript("return arguments[0].shadowRoot", element2) ;


        WebElement element3 = example2.findElement(By.id("ironPages"));
        WebElement example4 = (WebElement) jse.executeScript("return arguments[0].shadowRoot", element3) ;

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mainView")));
        WebElement element4 = example2.findElement(By.id("mainView"));

        WebElement example5 = (WebElement) jse.executeScript("return arguments[0].shadowRoot", element4) ;

        WebElement element5 = example5.findElement(By.tagName("session-creator"));
        WebElement example6 = (WebElement) jse.executeScript("return arguments[0].shadowRoot", element5) ;

        WebElement element6 = example6.findElement(By.tagName("entity-search"));
        WebElement example7 = (WebElement) jse.executeScript("return arguments[0].shadowRoot", element6) ;

        WebElement element7 = example7.findElement(By.tagName("auto-complete-search"));
        WebElement example8 = (WebElement) jse.executeScript("return arguments[0].shadowRoot", element7) ;

        System.out.println("7");
        example8.findElement(inputInstrument).click();
        example8.findElement(inputInstrument).sendKeys(instrument_test);
        example6.findElement(createButton).click();
    }



    public WebElement goToStartTimeContainer(){
        WebElement s = sessionCreator.findElement(By.id("fromTime"));
        WebElement example = (WebElement) jse.executeScript("return arguments[0].shadowRoot", s);

        WebElement dateAndTime = example.findElement(By.cssSelector(".date-time-container"));
        WebElement date = example.findElement(By.id("datePicker"));
        WebElement time = example.findElement(By.id("timeInput"));

        return dateAndTime;

    }
    public WebElement goToEndTimeContainer(){
        WebElement s = sessionCreator.findElement(By.id("toTime"));
        WebElement example = (WebElement) jse.executeScript("return arguments[0].shadowRoot", s);

        WebElement dateAndTime = example.findElement(By.cssSelector(".date-time-container"));
        WebElement date = example.findElement(By.id("datePicker"));
        WebElement time = example.findElement(By.id("timeInput"));

        return dateAndTime;


    }

    public void checkNotificationPopUp() {
        //Assert.assertEquals(autoCompleteSearch.findElement(By.id("notification")).getText(), "Start time is equal to the end time.");

    }
    public WebElement goToMainView() throws Exception{
        Thread.sleep(5000);
        System.out.println("1");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("mrs-app-component")));
        System.out.println("11");
        WebElement element = this.driver.findElement(By.tagName("mrs-app-component"));
        System.out.println("111");

        WebElement example = (WebElement) jse.executeScript("return arguments[0].shadowRoot", element);
        System.out.println("11111");
        System.out.println(example.getAttribute("innerHTML"));
        Thread.sleep(300);
        WebElement element2 = example.findElement(By.tagName("mrs-app-container"));
        WebElement example2 = (WebElement) jse.executeScript("return arguments[0].shadowRoot", element2);
        Thread.sleep(300);
        WebElement element3 = example2.findElement(By.id("ironPages"));
        WebElement example4 = (WebElement) jse.executeScript("return arguments[0].shadowRoot", element3) ;

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mainView")));
        WebElement element4 = example2.findElement(By.id("mainView"));

        WebElement example5 = (WebElement) jse.executeScript("return arguments[0].shadowRoot", element4) ;
        return example5;

    }
    public WebElement goToSessionCreator() {
        WebElement element5 = mainView.findElement(By.tagName("session-creator"));
        WebElement example6 = (WebElement) jse.executeScript("return arguments[0].shadowRoot", element5) ;
        return example6;
    }

    public WebElement goToEntitySearch() {
        WebElement element6 = sessionCreator.findElement(By.tagName("entity-search"));
        WebElement example7 = (WebElement) jse.executeScript("return arguments[0].shadowRoot", element6) ;
        return example7;
    }

    public WebElement goToAutoCompleteSearch(){
        WebElement element7 = entitySearch.findElement(By.tagName("auto-complete-search"));
        WebElement example8 = (WebElement) jse.executeScript("return arguments[0].shadowRoot", element7) ;
        return example8;

    }

    public void changeEndTime(){}
}
