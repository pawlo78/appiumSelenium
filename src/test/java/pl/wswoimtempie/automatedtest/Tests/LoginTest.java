package pl.wswoimtempie.automatedtest.Tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.wswoimtempie.automatedtest.Pages.HomePage;
import pl.wswoimtempie.automatedtest.Pages.LoginPage;

import java.net.MalformedURLException;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "data-provider")
    public void LoginWithErrorDataTest(String email, String pass, String errorMessage) throws MalformedURLException {

        LoginPage loginPage = new HomePage().avatarLoginClick()
                .setEmail(email)
                .setPass(pass)
                .logInClickButton();

        String message = loginPage.getToastMessage();
        Assert.assertEquals(message, errorMessage);
    }

    @DataProvider(name = "data-provider")
    public Object[][] loginData() {
        return new Object[][]{
                {"pawlo@pawlo.pl", "asdfg", "Invalid Login"},
                {"tomek@pawlo.pl", "3edcvfr4", "Invalid Login"},
                {"", "", "Login failed"}
        };
    }
}
