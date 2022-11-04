package pl.wswoimtempie.automatedtest.Pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotelPage {

    private AndroidDriver driver;

    public SearchHotelPage(AndroidDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//android.widget.ImageView")
    public WebElement hotelImage;

    @FindBy(id = "android:id/search_src_text")
    public WebElement searchCityInput;

    @FindBy(id = "com.phptravelsnative:id/top")
    public WebElement firstResult;

    @FindBy(id = "com.phptravelsnative:id/dateselectedfrom")
    public WebElement openCalendar;

    @FindBy(xpath = "//android.widget.TextView[@text = '15']")
    public WebElement checkInData;

    @FindBy(xpath = "//android.widget.TextView[@text = '18']")
    public WebElement checkOutData;

    @FindBy(id = "com.phptravelsnative:id/search_done")
    public WebElement doneButton;

    @FindBy(id = "com.phptravelsnative:id/numberadults")
    public WebElement openSetTravellers;

    @FindBy(id = "com.phptravelsnative:id/room_increase")
    public WebElement roomIncrease;

    @FindBy(id = "com.phptravelsnative:id/a_increase")
    public WebElement adultIncrease;

    @FindBy(id = "com.phptravelsnative:id/c_increase")
    public WebElement childIncrease;

    @FindBy(id = "com.phptravelsnative:id/done")
    public WebElement doneButtonInSearch;

    @FindBy(id = "com.phptravelsnative:id/search_Hotel")
    public WebElement searchHotelButton;


    public SearchHotelPage setCity() {
        hotelImage.click();
        searchCityInput.sendKeys("Singa");
        firstResult.click();
        return this;
    }

    public SearchHotelPage setDates() {
        openCalendar.click();
        checkInData.click();
        checkOutData.click();
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

    public SearchHotelResultPage performSearch() {
        doneButtonInSearch.click();
        searchHotelButton.click();
        return new SearchHotelResultPage(driver);
    }
}