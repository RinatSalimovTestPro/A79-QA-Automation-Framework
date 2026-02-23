import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.util.List;

public class Homework20 extends BaseTest{
    @Test
    @Parameters("baseUrl")
    public void deletePlaylist(String baseUrl) {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        //Login with valid credentials
        loginPage.login();

        By playlistsLocator = By.cssSelector("li.playlist a");
        List<WebElement> playlists = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(playlistsLocator, 0));

        WebElement newPlaylistButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("i[data-testid='sidebar-create-playlist-btn']")));


        String playlistName = homePage.generateRandomName();

        if  (playlists.size() >= 3) {
            playlists.get(2).click();
        } else  {
            newPlaylistButton.click();

            WebElement createPlaylistButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[data-testid='playlist-context-menu-create-simple']")));

            createPlaylistButton.click();

            WebElement newPlaylistName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='name'][placeholder='↵ to save']")));

            newPlaylistName.click();
            newPlaylistName.clear();
            newPlaylistName.sendKeys(playlistName);
            newPlaylistName.sendKeys(Keys.ENTER);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.success.show")));
        }

        WebElement deletePlaylistButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.del.btn-delete-playlist[title='Delete this playlist']")));
        deletePlaylistButton.click();

        WebElement notification = driver.findElement(By.cssSelector("div[class='success show']"));
        Assert.assertTrue(notification.isDisplayed());
    }

}

