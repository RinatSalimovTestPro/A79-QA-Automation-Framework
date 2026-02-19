package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends BasePage{

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);

    }

    By avatarIcon = By.cssSelector("img.avatar");

    By playlistClick = By.xpath("(//li[contains(@class,'playlist')]//a)[3]");

    By playlistInputField = By.cssSelector("[name='name']");

    By notification = By.cssSelector("div.success.show");

    public WebElement getUserAvatar() {
        return findElement(avatarIcon);
    }

    public void doubleClickPlaylist() {
        Actions action = new Actions(driver);
        action.doubleClick(findElement(playlistClick)).perform();
    }

    public void enterNewPlaylistName(String newName) {
        findElement(playlistInputField).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        findElement(playlistInputField).sendKeys(Keys.BACK_SPACE);

        findElement(playlistInputField).sendKeys(newName);
        findElement(playlistInputField).sendKeys(Keys.ENTER);
    }

    public String getRenamePlaylistSuccessMsg() {
        return findElement(notification).getText();
    }


}
