package pl.wswoimtempie.automatedtest.Pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private AndroidDriver driver;

    public HomePage(AndroidDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "com.phptravelsnative:id/testuserrr")
    public WebElement userAvatar;

    @FindBy(xpath = "//android.widget.TextView[@text = 'HOTELS']/..")
    public WebElement inputHotels;

    public LoginPage avatarLoginClick() {
        userAvatar.click();
        return new LoginPage(driver);
    }

    public SearchHotelPage hotelsClick() {
        inputHotels.click();
        return new SearchHotelPage(driver);
    }
}