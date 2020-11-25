package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class ContentPage extends MainPage{

    public WebElement replayController;
    //buttons
    public By playPauseButton = By.id("playPause");
    public By previousEventButton = By.id("btn-previous");
    public By nextEventButton = By.id("btn-next");

    public ContentPage(WebDriver driver, WebDriverWait wait) throws Exception {
        super(driver, wait);
        this.replayController = goToReplayController();


    }

    public WebElement goToReplayController() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement element7 = mainView.findElement(By.tagName("replay-controller"));
        WebElement example8 = (WebElement) jse.executeScript("return arguments[0].shadowRoot", element7);
        return example8;
    }







    Function<? super WebDriver, Object> isTextPresent = new ExpectedCondition<Object>() {
        @Override
        public Boolean apply(WebDriver webDriver) {
            return  webDriver.findElement(By.tagName("body")).getText().contains("New topic");
        }
    };

    public void playSession() {
        //driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement example = (WebElement) jse.executeScript("return arguments[0].shadowRoot", this.replayController.findElement(playPauseButton));
        WebDriverWait wait = new WebDriverWait(driver, 180);

        //driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
       // wait.until(ExpectedConditions.elementToBeClickable(By.id("playButton")));
        example.findElement(By.id("playButton")).click();


    }



}
