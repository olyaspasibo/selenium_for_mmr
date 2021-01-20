package pages;

//import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LogIn {

    public  WebDriver driver;
    private WebDriverWait wait;
    // Cognito buttons. xPath selector used because thare are duplicates with same id.
    private By userName = By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div[2]/div/div/form/div[1]/input");
    private By passWord = By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div[2]/div/div/form/div[2]/input");
    private By loginButton =  By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div[2]/div/div/form/input[3]");
    private By instrumentField = By.xpath("html/body/mrs-app-component//div/mrs-app-container//iron-pages" +
                    "/main-view//div[2]/div[1]/session-creator//div[2]/entity-search//div/auto-complete-search//input");


    public LogIn(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }


    // Just a short cut
    public void sendKeysTo(WebElement input, String st) {
        input.click();
        input.sendKeys(st);
    }

    // xMR web-page consists of shadow-root elements. Therefore, it's impossible to manipulate web-elements
    // directly. This function is used for unwrapping shadow-root.
    public WebElement getOutOfDom(String [] arr) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement mrsAppcomp = driver.findElement(By.tagName("mrs-app-component"));
        System.out.println(mrsAppcomp);
        WebElement shadow = (WebElement) jse.executeScript("return arguments[0].shadowRoot", mrsAppcomp);
        WebElement mrsAppcont = shadow.findElement(By.tagName("mrs-app-container"));
        WebElement shadow1 = (WebElement) jse.executeScript("return arguments[0].shadowRoot", mrsAppcont);
        WebElement elem = null;
        for (int i = 0;i<arr.length;i++){
            elem = shadow1.findElement(By.id(arr[i]));
            if (i==(arr.length-1))
                break;
            shadow1 = (WebElement) jse.executeScript("return arguments[0].shadowRoot", elem);
        }
        return elem;
    }


//    @Step("Loging in")
    public void logIn(String email, String password) throws Exception{
        // Open and run web-driver.
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();

        // Start timer
        //long startTime = System.nanoTime();

        driver.get("https://qa1-lsegxmr.com/mrs");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 120);

        // Login (Cognito)
        WebElement login = driver.findElement(userName);
        sendKeysTo(login, email);
        WebElement password_w = driver.findElement(passWord);
        sendKeysTo(password_w, password);

        driver.findElement(loginButton).click();
        driver.manage().window().maximize();
        //String selectAll = Keys.chord(Keys.COMMAND, "h");
        //driver.findElement(passWord).sendKeys(selectAll);
        //Actions action = new Actions(driver);
        //action.sendKeys(Keys.COMMAND, "t");


        //action.keyDown(Keys.CONTROL).sendKeys(String.valueOf('\u0061')).perform();
//        double endTime = System.nanoTime();
//
//        double duration = (endTime - startTime);
//        System.out.println("Time: " + duration);
//        System.out.println("Time: " + (duration/1000000000));
//
//        Thread.sleep(4000);
//
//        WebElement inputTextBox = getOutOfDom(new String[]{"mainView", "sessionCreator", "entitySearch1",
//                "autoCompleteSearch", "inputTextBox"});
//
//
//        wait.until(ExpectedConditions.elementToBeClickable(inputTextBox));
//        inputTextBox.click();
//
//        inputTextBox.sendKeys("LSE");
//        System.out.println("4");
//
//        WebElement startDay = getOutOfDom(new String[]{"mainView", "sessionCreator", "fromTime",
//                "datePicker", "dateInput","firstInput", "numberInput"});
//        startDay.click();
//        startDay.clear();
//        startDay.sendKeys("03");


//
//        WebElement startMonth = getOutOfDom(new String[]{"mainView", "sessionCreator", "fromTime",
//                "datePicker", "dateInput", "secondInput", "numberInput"});
//        startMonth.click();
//        startMonth.clear();
//        startMonth.sendKeys("09");
//
//
//        WebElement startYear = getOutOfDom(new String[]{"mainView", "sessionCreator", "fromTime",
//                "datePicker", "dateInput", "thirdInput", "numberInput"});
//        startYear.click();
//        startYear.clear();
//        startYear.sendKeys("2019");

//        WebElement instr = getOutOfDom(new String[]{"mainView", "sessionCreator", "entitySearch1",
//                "autoCompleteSearch", "inputTextBox"});
//        instr.sendKeys("BP.");
//        WebElement startHour = getOutOfDom(new String[]{"mainView", "sessionCreator", "fromTime",
//                "timeInput", "hours", "numberInput"});
//        startHour.click();
//        startHour.clear();
//        driver.manage().window().maximize();
//        startHour.sendKeys("06");
//
//        WebElement startMinute = getOutOfDom(new String[]{"mainView", "sessionCreator", "fromTime",
//                "timeInput", "minutes", "numberInput"});
//        startMinute.click();
//        startMinute.clear();
//        startMinute.sendKeys("00");
//
//
//
//
//        WebElement createButton = getOutOfDom(new String[]{"mainView", "sessionCreator", "createButton"});
//        createButton.click();
//
//
//
//        Thread.sleep(15000);
        //WebElement queryLoadingSpin = getOutOfDom(new String[]{"mainView", "sessionCreator"});
        //System.out.println(queryLoadingSpin.getAttribute("innerHTML"));
        //div.query-loading-container
        //WebElement spin = queryLoadingSpin.findElement(By.className("query-loading"));

        //wait.until(ExpectedConditions.invisibilityOf(spin));

        //*[@id="sessionCreator"]//div[1]

//        WebElement playButton = getOutOfDom(new String[]{"mainView", "replayController", "playPause", "playButton"});
//        playButton.click();

//        long startTime = System.nanoTime();
//
//        WebElement eventNavigator = getOutOfDom(new String[]{"mainView", "mainSplitterLayout", "eventLogContainer",
//                "eventLog", "entityDataTable", "dataTable"});
//        wait.until(
//                ExpectedConditions.visibilityOf(eventNavigator));
//        double endTime = System.nanoTime();
//
//        double duration = (endTime - startTime);// / 1000000000;
//        System.out.println("Time: " + duration);
//        System.out.println("Time: " + (duration/ 1000000000));



        //private By instrumentField = By.xpath("html/body/mrs-app-component//div/mrs-app-container//iron-pages" +
        //        "/main-view//div[2]/div[1]/session-creator//div[2]/entity-search//div/auto-complete-search//input");

    }
}
