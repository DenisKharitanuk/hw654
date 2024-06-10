package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FiltersPage extends BasePage {
    //locators block
    private By priceStartInLocator = By.name("startN");
    private By endPriceLocator = By.name("endN");
    private By showButtonLocator = By.className("filters-desktop__btn-main");

    //constructors block
    public FiltersPage(WebDriver driver) {
        super(driver);
    }

    // getters block
    private WebElement getShowButton() {
        return waitsService.waitForExist(showButtonLocator);
    }

    private WebElement getPriceStartIn() {
        return waitsService.waitForExist(priceStartInLocator);
    }

    private WebElement getEndPrice() {
        return waitsService.waitForExist(endPriceLocator);
    }

    private WebElement getRadioOrCheckboxButton(String OrCheckbox) {
        return waitsService.waitForVisibilityBy(By.xpath("//span[text()='" + OrCheckbox + "']/preceding-sibling::span"));
    }

    //actions block
    public FiltersPage clearAndInputStartInPrice(String priceStartIn) {
        getPriceStartIn().clear();
        getPriceStartIn().sendKeys(priceStartIn);
        return this;
    }

    public FiltersPage clearAndInputEndPrice(String endPrice) {
        getEndPrice().clear();
        getEndPrice().sendKeys(endPrice);
        return this;
    }

    public FiltersPage clickOnRadioAndCheckboxButton(String radioOrCheckboxButtonName) {
        getRadioOrCheckboxButton(radioOrCheckboxButtonName).click();
        return this;
    }

    public CatalogPage clickOnShowButton() {
        getShowButton().click();
        return new CatalogPage(driver);
    }
}
