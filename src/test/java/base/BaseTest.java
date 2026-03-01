package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final ThreadLocal<WebDriverWait> wait = new ThreadLocal<>();
    private static final ThreadLocal<Actions> actions = new ThreadLocal<>();

    protected String url;

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static WebDriverWait getWait() {
        return wait.get();
    }

    public static Actions getActions() {
        return actions.get();
    }

    @BeforeMethod
    @Parameters({"baseUrl"})
    public void launchBrowser(@Optional("https://qa.koel.app/") String baseUrl) throws MalformedURLException {

        String username = System.getenv("LT_USERNAME");
        String accessKey = System.getenv("LT_ACCESS_KEY");

        if (username == null || accessKey == null) {
            throw new RuntimeException("Missing LT_USERNAME or LT_ACCESS_KEY in environment variables");
        }

        String hubUrl = "https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub";

        ChromeOptions options = new ChromeOptions();
        options.setPlatformName("Windows 10");
        options.setBrowserVersion("latest");

        options.addArguments("--remote-allow-origins=*");

        driver.set(new RemoteWebDriver(new URL(hubUrl), options));

        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().manage().window().maximize();

        wait.set(new WebDriverWait(getDriver(), Duration.ofSeconds(10)));
        actions.set(new Actions(getDriver()));

        url = baseUrl;
        navigatingToPage();
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {

        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
            wait.remove();
            actions.remove();
        }
    }

    public void navigatingToPage() {
        getDriver().get(url);
    }
}