package pl.wswoimtempie.automatedtest.Tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    public AndroidDriver driver;

    @BeforeMethod
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        //nazwa emulatora z androidstudio
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "firstEmulator");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        //uruchomienie aplikacji na emulatorze, dodanie paczki i activity
        caps.setCapability("appPackage", "com.phptravelsnative");
        caps.setCapability("appActivity", "com.phptravelsnative.Activities.SplashActivity");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}