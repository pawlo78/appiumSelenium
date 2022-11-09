package pl.wswoimtempie.automatedtest.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.wswoimtempie.automatedtest.utils.DriverFactory;

import java.net.MalformedURLException;
import java.time.ZoneId;
import java.util.Date;

public class SearchHotelPage {

    //

    public SearchHotelPage() throws MalformedURLException {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    @FindBy(xpath = "//android.widget.ImageView")
    private WebElement hotelImage;

    @FindBy(id = "com.phptravelsnative:id/searchplace")
    private WebElement searchWhereCityString;


    @FindBy(id = "android:id/search_src_text")
    private WebElement searchCityInput;

    @FindBy(id = "com.phptravelsnative:id/top")
    private WebElement firstResult;

    @FindBy(id = "com.phptravelsnative:id/dateselectedfrom")
    private WebElement openCalendar;

    @FindBy(id = "com.phptravelsnative:id/search_done")
    private WebElement doneButton;

    @FindBy(id = "com.phptravelsnative:id/numberadults")
    private WebElement openSetTravellers;

    @FindBy(id = "com.phptravelsnative:id/room_increase")
    private WebElement roomIncrease;

    @FindBy(id = "com.phptravelsnative:id/a_increase")
    private WebElement adultIncrease;

    @FindBy(id = "com.phptravelsnative:id/c_increase")
    private WebElement childIncrease;

    @FindBy(id = "com.phptravelsnative:id/done")
    private WebElement doneButtonInSearch;

    @FindBy(id = "com.phptravelsnative:id/search_Hotel")
    private WebElement searchHotelButton;


    public SearchHotelPage setCity() {
        hotelImage.click();
        searchWhereCityString.click();
        searchCityInput.sendKeys("Singa");
        firstResult.click();
        return this;
    }

    public SearchHotelPage setDates() throws MalformedURLException {
        int checkingDay = new Date().toInstant().atZone(ZoneId.systemDefault()).getDayOfMonth();
        int checkoutDay = checkingDay + 2;
        By checkinDaySel = By.xpath("//android.widget.TextView[@text = '" + checkingDay + "']");
        By checkoutDaySel = By.xpath("//android.widget.TextView[@text = '" + checkoutDay + "']");

        openCalendar.click();
        DriverFactory.getDriver().findElement(checkinDaySel).click();
        DriverFactory.getDriver().findElement(checkoutDaySel).click();
        doneButton.click();
        return this;
    }

    public SearchHotelPage setTravellers() {
        openSetTravellers.click();
        roomIncrease.click();
        adultIncrease.click();
        childIncrease.click();
        return this;
    }

    public SearchHotelResultPage performSearch() throws MalformedURLException {
        doneButtonInSearch.click();
        searchHotelButton.click();
        return new SearchHotelResultPage(DriverFactory.getDriver());
    }
}