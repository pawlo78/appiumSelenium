package pl.wswoimtempie.automatedtest.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.wswoimtempie.automatedtest.utils.DriverFactory;

import java.net.MalformedURLException;

public class LoginPage {

    private static Logger logger = LoggerFactory.getLogger(LoginPage.class);

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


    public LoginPage setEmail(String email) throws MalformedURLException {
        logger.info("Setting E-mail with value: " + email);
        inputEmailId.clear();
        inputEmailId.sendKeys(email);
        return this;
    }

    public LoginPage setPass(String pass) throws MalformedURLException {
        logger.info("Setting pass with value: " + pass);
        inputPasswordId.clear();
        inputPasswordId.sendKeys(pass);
        return this;
    }

    public LoginPage logInClickButton() {
        logger.info("Click login button");
        loginButtonId.click();
        return this;
    }

    @Step("Get toastMessage")
    public String getToastMessage() throws MalformedURLException {
        logger.info("Get toastMessage");
        return toastMessageXp.getText();
    }
}
