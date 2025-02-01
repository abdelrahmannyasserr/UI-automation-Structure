package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage extends PageBase {
    private final By pageTitle = By.xpath("//div[contains(text(), 'Welcome aboard')]");
    private final By radioTrip = By.xpath("//div[text()='round trip']");
    private final By selectFromCountryBtn = By.xpath("//*[@id=\"main-container\"]//div[1]/div[1]/div[2]/input");
    private final By firstRequiredCountry = By.xpath("//div[contains(text(), 'Agra')]");
    private final By secondRequiredCountry = By.xpath("//div[contains(text(), 'Indore')]");
    private final By nextArrowBtn = By.xpath("//div[contains(@class,'r-1loqt21 r-u8s1d')]");
    private final By requiredDateBtn = By.xpath("//*[@id=\"main-container\"]//div[3]/div/div[3]/div[2]/div[7]");
    private final By passengerDropDown = By.xpath("//div[contains(text(), 'Passengers')]");
    private final By adultCounterBtn = By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]//div[1]/div[2]/div[3]");
    private final By childrenCounterBtn = By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]//div[2]/div[2]/div[3]");
    private final By infantCounterBtn = By.xpath("//*[@id=\"main-container\"]/div/div//div[1]/div[3]/div/div[3]");
    private final By doneBtn = By.xpath("//div[contains(text(), 'Done')]");
    private final By currencyDropDown = By.xpath("//div[contains(text(), 'Currency')]");
    private final By usdCurrency = By.xpath("//div[contains(text(), 'USD')]");
    private final By nextMonthFlag = By.xpath("//div[contains(text(), 'September')]");
    private final By searchFlightBtn = By.xpath("//div[contains(text(), 'Search')]");

    private final By searchResultMessage = By.xpath("//div[contains(text(), 'Flight Details')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    JavascriptExecutor executor = (JavascriptExecutor) driver;
    WebDriverWait wait = new WebDriverWait(driver, 5);

    public void assertThatHomePageIsDisplayed() {
        assertElementIsDisplayed(pageTitle);
    }

    public void chooseRoundTrip() {
        clickOnElement(radioTrip);
    }

    public void chooseTheCountry() {
        waitForElementToBeClickable(selectFromCountryBtn, 5);
        clickOnElement(selectFromCountryBtn);
        waitForElementToBeClickable(firstRequiredCountry, 5);
        clickOnElement(firstRequiredCountry);
        waitForElementToBeClickable(secondRequiredCountry, 5);
        clickOnElement(secondRequiredCountry);
    }

    public void setTheDate() throws InterruptedException {
        waitForElementToBeClickable(nextArrowBtn, 5);
        clickOnElement(nextArrowBtn);
//        waitForElementToBeVisible(nextMonthFlag, 2);
        Thread.sleep(300);
        waitForElementToBeClickable(requiredDateBtn, 5);
        clickOnElement(requiredDateBtn);
        waitForElementToBeClickable(nextArrowBtn, 5);
        clickOnElement(nextArrowBtn);
        clickOnElement(requiredDateBtn);
    }

    public void pickThePassenger() {
        clickOnElement(passengerDropDown);
        clickOnElement(adultCounterBtn);
        clickOnElement(childrenCounterBtn);
        clickOnElement(infantCounterBtn);
    }

    public void chooseTheCurrency() {
        waitForElementToBeClickable(currencyDropDown, 5);
        clickOnElement(currencyDropDown);
        clickOnElement(usdCurrency);
    }

    public void clickOnSearchFlightButton() throws InterruptedException {
        scrollIntoViewAndClick(searchFlightBtn);
    }

    public void assertThatSearchFlightNotExist() {
        assertElementNotDisplayed(searchResultMessage);
    }

}
