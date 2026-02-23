package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.UUID;

public class HomePage extends BasePage{

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);

    }

    Actions actions = new Actions(driver);

    @FindBy(css = "img.avatar")
    WebElement avatarIcon;

    @FindBy(xpath = "(//li[contains(@class,'playlist')]//a)[3]")
    WebElement playlistClick;

    @FindBy(css = "[name='name']")
    WebElement playlistInputField;

    @FindBy(css = "div.success.show")
    WebElement notification;

    @FindBy(css = "[type='search']")
    WebElement searchField;

    @FindBy(css = "[data-test='view-all-songs-btn']")
    WebElement viewAllButton;

    @FindBy(css = "a[class='songs']")
    WebElement allSongsButton;

    @FindBy(css = "[class='album-thumb-wrapper']")
    WebElement playButton;


    public WebElement getUserAvatar() {
        return avatarIcon;
    }

    public void doubleClickPlaylist() {
        Actions action = new Actions(driver);
        action.doubleClick((playlistClick)).perform();
    }

    public void enterNewPlaylistName(String newName) {
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        playlistInputField.sendKeys(Keys.BACK_SPACE);

        playlistInputField.sendKeys(newName);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public String getRenamePlaylistSuccessMsg() {
        return (notification).getText();
    }

    public void searchForSong(String songName) {
        searchField.click();
        searchField.clear();
        searchField.sendKeys(songName);
    }

    public void clickOnViewAllButton() {
        viewAllButton.click();
    }

    public String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "").substring(0,5);
    }

    public void clickOnAllSongsButton() {
        allSongsButton.click();
    }

    public WebElement hoverOnPlayButton() {
        actions.moveToElement(playButton).perform();
        return playButton;
    }





}



