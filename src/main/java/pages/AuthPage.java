package pages;

//import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthPage {
    public static WebDriver driver;
    private WebDriverWait wait;

    private By advanced = By.id("details-button");
    private By proceed = By.id("proceed-link");
    private By userName = By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div[2]/div/div/form/div[1]/input");
    private By passWord = By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div[2]/div/div/form/div[2]/input");
    private By loginButton =  By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div[2]/div/div/form/input[3]");
    private By instrumentField = By.xpath("html/body/mrs-app-component//div/mrs-app-container//iron-pages" +
            "/main-view//div[2]/div[1]/session-creator//div[2]/entity-search//div/auto-complete-search//input");
    private String password = "London1234!";
    private String test_name = "TestUser";
    private By newPassword = By.id("new_password");
    private By confirmPassword = By.id("confirm_password");
    private By resetPassword = By.name("reset_password");
    private By givenName = By.id("given_name");
    private By familyName = By.id("family_name");


    public AuthPage(WebDriver driver, WebDriverWait wait) {
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
        //System.out.println(mrsAppcomp);
        WebElement shadow = (WebElement) jse.executeScript("return arguments[0].shadowRoot", mrsAppcomp);

        WebElement mrsAppcont = shadow.findElement(By.tagName("mrs-app-container"));

        WebElement shadow1 = (WebElement) jse.executeScript("return arguments[0].shadowRoot", mrsAppcont);
        //System.out.println(shadow1.getAttribute("innerHTML"));
        //System.out.println("----------");
        //mrsAppcont = shadow1.findElement(By.tagName("iron-pages"));
        //shadow1 = (WebElement) jse.executeScript("return arguments[0].shadowRoot", mrsAppcont);


        WebElement elem = null;
        for (int i = 0;i<arr.length;i++){
            elem = shadow1.findElement(By.id(arr[i]));
            if (i==(arr.length-1))
                break;

            shadow1 = (WebElement) jse.executeScript("return arguments[0].shadowRoot", elem);
            //System.out.println(shadow1.getAttribute("innerHTML"));
        }
        return elem;
    }

    public void logOut() throws InterruptedException {
        Thread.sleep(6000);
        /*wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/mrs-app-component//div/mrs-app-container" +
                "//iron-pages/main-view//div[2]/div[1]/application-header//div/div[10]/button")));*/
        WebElement logout =
                getOutOfDom(new String[]{"mainView", "applicationHeader", "logoutBtn"});
        logout.click();
        logout.click();

    }

    //int i = 15;

//    @Step("Loging in")
    public void auth(int i) throws Exception {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        System.out.println(i);
        driver.get("https://qa2-lsegxmr.com/mrs");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 120);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String email = "zQAA" + i;
        //i += 1;

        WebElement login = driver.findElement(userName);
        sendKeysTo(login, email);

        WebElement password_w = driver.findElement(passWord);
        sendKeysTo(password_w, password);

        driver.findElement(loginButton).click();
        driver.manage().window().maximize();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(newPassword)));
        driver.findElement(newPassword).click();
        driver.findElement(newPassword).sendKeys(password);
        driver.findElement(confirmPassword).click();
        driver.findElement(confirmPassword).sendKeys(password);
        driver.findElement(givenName).click();
        driver.findElement(givenName).sendKeys(test_name);
        driver.findElement(familyName).click();
        driver.findElement(familyName).sendKeys(test_name);
        driver.findElement(resetPassword).click();

//        Thread.sleep(8000);
//        System.out.println("1");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("mrs-app-component")));
//        System.out.println("2");
        logOut();
        driver.quit();
    }
}
