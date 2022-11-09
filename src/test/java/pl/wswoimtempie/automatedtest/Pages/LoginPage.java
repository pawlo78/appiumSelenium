package pl.wswoimtempie.automatedtest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.wswoimtempie.automatedtest.utils.DriverFactory;

import java.net.MalformedURLException;

public class LoginPage {

    public LoginPage() throws MalformedURLException {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    @FindBy(id = "com.phptravelsnative:id/input_email")
    private WebElement inputEmailId;

    @FindBy(id = "com.phptravelsnative:id/input_password")
    private WebElement inputPasswordId;

    @FindBy(id = "com.phptravelsnative:id/btn_login")
    private WebElement loginButtonId;

    @FindBy(xpath = "//android.widget.Toast[contains(@text, 'Login')]")
    private WebElement toastMessageXp;


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
