package pl.wswoimtempie.automatedtest.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pl.wswoimtempie.automatedtest.utils.DriverFactory;

import java.net.MalformedURLException;
import java.time.Duration;

public class BaseTest {

    @BeforeMethod
    public void setup() throws MalformedURLException {
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterMethod
    public void tearDown() throws MalformedURLException {
        DriverFactory.getDriver().quit();
    }

}