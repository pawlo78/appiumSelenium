package pl.wswoimtempie.automatedtest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.wswoimtempie.automatedtest.utils.AppiumHelper;
import pl.wswoimtempie.automatedtest.utils.DriverFactory;

import java.net.MalformedURLException;

public class HomePage {

    private static Logger logger = LoggerFactory.getLogger(HomePage.class);

    public HomePage() throws MalformedURLException {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    @FindBy(id = "com.phptravelsnative:id/testuserrr")
    private WebElement userAvatar;

    @FindBy(xpath = "//android.widget.TextView[@text = 'HOTELS']/..")
    private WebElement inputHotels;

    @FindBy(id = "com.phptravelsnative:id/sidedrawer")
    private WebElement menuButton;

    public LoginPage avatarLoginClick() throws MalformedURLException {
        logger.info("Opening login page");
        AppiumHelper.takeScreenShot();
        userAvatar.click();
        return new LoginPage();
    }

    public SearchHotelPage hotelsClick() throws MalformedURLException {
        inputHotels.click();
        return new SearchHotelPage();
    }

    public SettingsPage openMenu() throws MalformedURLException {
        menuButton.click();
        AppiumHelper.takeScreenShot();
        return new SettingsPage();
    }

}