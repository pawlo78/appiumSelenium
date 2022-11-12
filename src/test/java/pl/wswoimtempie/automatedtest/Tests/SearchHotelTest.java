package pl.wswoimtempie.automatedtest.Tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.wswoimtempie.automatedtest.Pages.HomePage;
import pl.wswoimtempie.automatedtest.Pages.SearchHotelResultPage;
import pl.wswoimtempie.automatedtest.Pages.SettingsPage;

import java.net.MalformedURLException;

public class SearchHotelTest extends BaseTest {

    @Test(priority = 1)
    public void searchHotel() throws MalformedURLException {
        SearchHotelResultPage searchHotelPage = new HomePage()
                .hotelsClick()
                .setCity()
                .setDates()
                .setTravellers()
                .performSearch();

        Assert.assertEquals(searchHotelPage.getHotelNames().get(0), "Rendezvous Hotels");
        Assert.assertEquals(searchHotelPage.getHotelNames().get(1), "Swissotel Le Plaza Basel");
        Assert.assertEquals(searchHotelPage.getHotelPrices().get(0), "USD 78.14");
        Assert.assertEquals(searchHotelPage.getHotelPrices().get(1), "USD 73.54");
    }

    @Test
    @Feature("Feature")
    @Description("Log in with invalid password ")
    public void setSettingsTest() throws MalformedURLException {
        SettingsPage settingsPage = new HomePage()
                .openMenu().setSettings();
    }

}