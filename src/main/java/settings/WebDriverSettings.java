package settings;


//import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


public class WebDriverSettings {
    public EventFiringWebDriver driver;
    public WebDriverWait wait;
    private By advanced = By.id("details-button");
    private By proceed = By.id("proceed-link");

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

    public void logOut() {
        WebElement logout = getOutOfDom(new String[]{"mainView", "applicationHeader", "logoutBtn"});
        System.out.println("3");
        logout.click();
        System.out.println("4");

    }

    @BeforeTest
    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
//        driver = new EventFiringWebDriver(new ChromeDriver());
//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("incognito");
//        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//        driver.get("https://qa2-lsegxmr.com/mrs");
//        driver.manage().window().maximize();
//        wait = new WebDriverWait(driver, 120);
        //driver.findElement(advanced).click();
        //driver.findElement(proceed).click();


    }

    @AfterTest
    public void close() throws InterruptedException {
//        Thread.sleep(3000);
//        System.out.println("1");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("mrs-app-component")));
//        System.out.println("2");
        //logOut();
        //driver.quit();
    }
}
