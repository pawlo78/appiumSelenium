package pl.wswoimtempie.automatedtest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.wswoimtempie.automatedtest.utils.DriverFactory;

import java.net.MalformedURLException;
import java.util.List;

public class SettingsPage {

    public SettingsPage() throws MalformedURLException {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    @FindBy(id = "com.phptravelsnative:id/icon")
    private List<WebElement> settingsButton;
    //get(6).click()
    @FindBy(id = "com.phptravelsnative:id/selectnamecodesetting")
    private WebElement inputLanguage;

    @FindBy(id = "com.phptravelsnative:id/langename")
    private List<WebElement> inputEnglish;
    //get(2).click

    @FindBy(id = "com.phptravelsnative:id/Currencysetting")
    private WebElement inputCurrency;

    @FindBy(id = "com.phptravelsnative:id/top")
    private List<WebElement> inputUsd;
    //get(0).click

    @FindBy(id = "com.phptravelsnative:id/back")
    private WebElement settingsExitButton;

    public SettingsPage setSettings() {
        settingsButton.get(6).click();
        inputLanguage.click();
        inputEnglish.get(2).click();
        inputCurrency.click();
        inputUsd.get(0).click();
        settingsExitButton.click();
        return this;
    }

}
