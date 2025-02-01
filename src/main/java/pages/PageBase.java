package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;

public class PageBase {

    protected WebDriver driver;
    Select select;

    public PageBase(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnElement(By element) {
        driver.findElement(element).click();
    }

    public void setElementText(By element, String text) {
        driver.findElement(element).sendKeys(text);
    }

    public String getElementText(By element) {
        return driver.findElement(element).getText();
    }

    public void selectFromDropDown(By element, String text) {
        WebElement dropDown = driver.findElement(element);
        select = new Select(dropDown);
        select.selectByValue(text);
    }


    public void reloadPage() {
        driver.navigate().refresh();
    }

    public void clearTextField(By element) {
        driver.findElement(element).clear();
    }

    public void assertElementIsDisplayed(By element) {
        Assert.assertTrue(driver.findElement(element).isDisplayed(), "Element Not Displayed");
    }

    public void assertElementNotDisplayed(By element) {
        try {
            WebElement webElement = driver.findElement(element);
            boolean isDisplayed = webElement.isDisplayed();
            Assert.assertFalse(isDisplayed, "Element is displayed");
        } catch (NoSuchElementException e) {
            // If NoSuchElementException is caught, it means the element is not present in the DOM.
            Assert.assertTrue(true, "Element is not displayed");
        }
    }

    public void waitForFixedDelay(int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return false;
            }
        });
    }

    public void waitForElementToBeClickable(By elementLocator, int timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public void waitForElementToBeVisible(By element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void scrollIntoView(By locator) {
        WebElement element = driver.findElement(locator);

        // Scroll the element into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        // Explicit wait for the element to be clickable
        WebDriverWait wait = new WebDriverWait(driver, 10); // Adjust the timeout as needed
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public void scrollIntoViewAndClick(By locator) {
        // Find the element
        WebElement element = driver.findElement(locator);

        // Scroll the element into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        // Click the element using JavaScript to bypass any potential click interception
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }


//    public void scrollIntoViewAndClick( By locator) {
//        // Find the element
//        WebElement element = driver.findElement(locator);
//
//        // Scroll the element into view
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//
//        // Explicit wait for the element to be clickable
//        WebDriverWait wait = new WebDriverWait(driver, 10); // Adjust the timeout as needed
//        wait.until(ExpectedConditions.elementToBeClickable(element));
//
//        // Click the element
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
//    }

    public void assertElementIsDeleted(By element) {
        Assert.assertFalse(driver.findElement(element).isDisplayed(), "Element Displayed");
    }

    public void pressEnterKey(WebElement element) {
        element.sendKeys(Keys.ENTER);
    }

    public void selectByVisibleText(String option) {
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(text(), '" + option + "')]")));
        pressEnterKey((WebElement) By.xpath("div[@role='listbox']//span[text()='" + option + "']"));
    }


}
