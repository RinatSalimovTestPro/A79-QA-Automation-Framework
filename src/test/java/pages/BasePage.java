package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected final WebDriver driver;
    protected final WebDriverWait wait;
    protected final Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    protected WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private final By pauseBtn = By.cssSelector("[data-testid='pause-btn']");

    public boolean isSongPlaying() {
        return !driver.findElements(pauseBtn).isEmpty()
                && driver.findElement(pauseBtn).isDisplayed();
    }

    public boolean isSongPlayingWait() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(pauseBtn));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}