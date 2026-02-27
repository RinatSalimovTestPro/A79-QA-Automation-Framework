/*import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
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

    public void navigatingToPage() {
        driver.get(url);
    }
}*/

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.time.Duration;

public class BaseTest  {

    public static WebDriver driver = null;
    public String url = null;
    public static WebDriverWait wait = null;
    public static Actions actions = null;

    @BeforeMethod
    @Parameters({"baseUrl"})
    public void launchBrowser(@Optional("https://qa.koel.app/") String baseUrl) throws MalformedURLException {

        // options for Chrome on Grid
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        // Selenium Grid URL (standalone)
        String gridUrl = "http://172.26.253.121:4444";
        // sometimes also works: "http://localhost:4444"

        driver = new RemoteWebDriver(java.net.URI.create(gridUrl).toURL(), options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        url = baseUrl;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);

        navigatingToPage();
    }

    @AfterMethod
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void navigatingToPage() {
        driver.get(url);
    }
}

