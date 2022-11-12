package pl.wswoimtempie.automatedtest.utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.net.MalformedURLException;
import java.time.Duration;

public class AppiumHelper {

    public static void waitForElementToBeClicable(By locator) throws MalformedURLException {
        Wait wait = new FluentWait<>(DriverFactory.getDriver())
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
                .withTimeout(Duration.ofSeconds(5)).pollingEvery(Duration.ofSeconds(1));

        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    @Attachment
    public static byte[] takeScreenShot() throws MalformedURLException {
        return ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
