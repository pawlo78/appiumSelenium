package pl.wswoimtempie.automatedtest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.wswoimtempie.automatedtest.utils.DriverFactory;

import java.net.MalformedURLException;

public class HomePage {

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
        userAvatar.click();
        return new LoginPage();
    }

    public SearchHotelPage hotelsClick() throws MalformedURLException {
        inputHotels.click();
        return new SearchHotelPage();
    }

    public SettingsPage openMenu() throws MalformedURLException {
        menuButton.click();
        return new SettingsPage();
    }

}