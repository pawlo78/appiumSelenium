package pl.wswoimtempie.automatedtest.Pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(AndroidDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "com.phptravelsnative:id/input_email")
    public WebElement inputEmailId;

    @FindBy(id = "com.phptravelsnative:id/input_password")
    public WebElement inputPasswordId;

    @FindBy(id = "com.phptravelsnative:id/btn_login")
    public WebElement loginButtonId;

    @FindBy(xpath = "//android.widget.Toast[contains(@text, 'Login')]")
    public WebElement toastMessageXp;


    public LoginPage setEmail(String email) {
        inputEmailId.clear();
        inputEmailId.sendKeys(email);
        return this;
    }

    public LoginPage setPass(String pass) {
        inputPasswordId.clear();
        inputPasswordId.sendKeys(pass);
        return this;
    }

    public LoginPage logInClickButton() {
        loginButtonId.click();
        return this;
    }

    public String getToastMessage() {
        return toastMessageXp.getText();
    }
}
