package pl.wswoimtempie.automatedtest.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.wswoimtempie.automatedtest.Pages.HomePage;
import pl.wswoimtempie.automatedtest.Pages.SearchHotelResultPage;

public class SearchHotelTest extends BaseTest {

    @Test
    public void searchHotel() {

        SearchHotelResultPage searchHotelPage = new HomePage(driver)
                .hotelsClick()
                .setCity()
                .setDates()
                .setTravellers()
                .performSearch();

        Assert.assertEquals(searchHotelPage.getHotelNames().get(0), "Rendezvous Hotels");
        Assert.assertEquals(searchHotelPage.getHotelNames().get(1), "Swissotel Le Plaza Basel");
        Assert.assertEquals(searchHotelPage.getHotelPrices().get(0), "USD 85");
        Assert.assertEquals(searchHotelPage.getHotelPrices().get(1), "USD 8");

    }
}