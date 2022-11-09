package pl.wswoimtempie.automatedtest.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    private static AndroidDriver driver;

    public static AndroidDriver getDriver() throws MalformedURLException {

        if (driver == null) {
            DesiredCapabilities caps = new DesiredCapabilities();
            //nazwa emulatora z androidstudio
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel3a");
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
            //uruchomienie aplikacji na emulatorze, dodanie paczki i activity
            caps.setCapability("appPackage", "com.phptravelsnative");
            caps.setCapability("appActivity", "com.phptravelsnative.Activities.SplashActivity");
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        }
        return driver;
    }
}
