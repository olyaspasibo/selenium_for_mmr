package pages;



import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;


public class LogIn {
    public  WebDriver driver;
    private WebDriverWait wait;
    private By userName = By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div[2]/div/div/form/div[1]/input");
    private By passWord = By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div[2]/div/div/form/div[2]/input");
    private By loginButton =  By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div[2]/div/div/form/input[3]");
    private By instrumentField = By.xpath("html/body/mrs-app-component//div/mrs-app-container//iron-pages" +
                    "/main-view//div[2]/div[1]/session-creator//div[2]/entity-search//div/auto-complete-search//input");


    public LogIn(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void sendKeysTo(WebElement input, String st) {
        input.click();
        input.sendKeys(st);
    }

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


    //@Step("Loging in")
    public void logIn(String email, String password) throws Exception{
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        driver = new EventFiringWebDriver(new ChromeDriver());
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver.get("https://qa2-lsegxmr.com/mrs");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 120);



            WebElement login = driver.findElement(userName);
            sendKeysTo(login, email);

            WebElement password_w = driver.findElement(passWord);
            sendKeysTo(password_w, password);

            driver.findElement(loginButton).click();
            driver.manage().window().maximize();
            //driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");



        //driver.findElement(advanced).click();
        //driver.findElement(proceed).click();
        //Thread.sleep(3000);
//        for (int i = 0; i < 20; i++) {
//            jse.executeScript("window.open(\"https://qa1-lsegxmr.com/mrs\");");
//        }

//        driver.findElement(By.cssSelector("body")).sendKeys(Keys.COMMAND+"t");
//        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
//        driver.switchTo().window(tabs.get(1)); //switches to new tab
//        driver.get("https://www.facebook.com");

        //driver.switchTo().window(tabs.get(0)); // switch back to main screen
        //driver.get("https://www.news.google.com");
//        WebElement inputTextBox = getOutOfDom(new String[]{"mainView", "sessionCreator", "entitySearch1",
////                "autoCompleteSearch", "inputTextBox"});
////        inputTextBox.sendKeys("BP.");
////        WebElement startDay = getOutOfDom(new String[]{"mainView", "sessionCreator", "fromTime",
////                "datePicker", "dateInput","firstInput", "numberInput"});
////        startDay.click();
////        startDay.clear();
////        startDay.sendKeys("26");
////
////
////        WebElement startMonth = getOutOfDom(new String[]{"mainView", "sessionCreator", "fromTime",
////                "datePicker", "dateInput", "secondInput", "numberInput"});
////        startMonth.click();
////        startMonth.clear();
////        startMonth.sendKeys("09");
////
////
////        WebElement startYear = getOutOfDom(new String[]{"mainView", "sessionCreator", "fromTime",
////                "datePicker", "dateInput", "secondInput", "numberInput"});
////        startMonth.click();
////        startMonth.clear();
////        startMonth.sendKeys("2019");
        //driver.manage().window().maximize();
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
//                "timeInput", "hours", "numberInput"});
//        startMinute.click();
//        startMinute.clear();
//        startMinute.sendKeys("00");
//
//
//
//
//        WebElement createButton = getOutOfDom(new String[]{"mainView", "sessionCreator", "createButton"});
//        createButton.click();
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
