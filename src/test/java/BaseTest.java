import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest  {

    public static WebDriver driver = null;
    public String url = null;
    public static WebDriverWait wait = null;

    public static Actions actions = null;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"baseUrl"})
    public void launchBrowser(@Optional("https://qa.koel.app/") String baseUrl) {
        //Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        url = baseUrl;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        navigatingToPage();
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    public void clickOnLoginButton() {
        WebElement logInButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='submit']")));
        logInButton.click();
    }

    public void providePassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void provideEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
        emailField.click();
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void navigatingToPage() {
        driver.get(url);
    }
}