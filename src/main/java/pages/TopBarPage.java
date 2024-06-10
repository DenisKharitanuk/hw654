package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TopBarPage extends BasePage {

    //locators block
    private By searchInputLocator = By.id("searchInput");
    private By searchButtonLocator = By.id("applySearchBtn");
    private By clearButtonLocator = By.cssSelector(".search-catalog__btn.search-catalog__btn--clear");
    private By addressMenuLocator = By.cssSelector(".simple-menu__link.simple-menu__link--address");
    private By jMenuBurgerButtonLocator = By.className("nav-element__burger-line");
    private By basketButtonLocator = By.cssSelector(".navbar-pc__icon.navbar-pc__icon--basket");
    private By basketNavbarNotifyLocator = By.xpath("//span[@class='navbar-pc__notify']");


    public TopBarPage(WebDriver driver) {
        super(driver);
    }

    //getters block
    private WebElement getBasketButton() {
        return waitsService.waitForExist(basketButtonLocator);
    }

    private WebElement getBasketNavbarNotify() {
        return waitsService.waitForExist(basketNavbarNotifyLocator);
    }

    private WebElement getSearchInputLocator() {
        return waitsService.waitForExist(searchInputLocator);
    }

    private WebElement getSearchButtonLocator() {
        return waitsService.waitToBeClickableByLocator(searchButtonLocator);
    }

    private WebElement getClearButtonLocator() {
        return waitsService.waitToBeClickableByLocator(clearButtonLocator);
    }

    private WebElement getAddressMenuLocator() {
        return waitsService.waitToBeClickableByLocator(addressMenuLocator);
    }

    private WebElement getJMenuBurgerButtonLocator() {
        return waitsService.waitForVisibilityBy(jMenuBurgerButtonLocator);
    }


    //action block

    public CatalogPage searchProduct(String productName) {
        getSearchInputLocator().sendKeys(productName, Keys.ENTER);
        return new CatalogPage(driver);
    }

    public CatalogPage clickOnSearchButton() {
        getSearchButtonLocator().click();
        return new CatalogPage(driver);
    }

    public TopBarPage clearSearchLine() {
        getClearButtonLocator().click();
        return this;
    }

    public MapPage clickOnAddressLocator() {
        getAddressMenuLocator().click();
        return new MapPage(driver);
    }

    public BurgerMenuBarPage clickOnjBurgerMenuButton() {
        getJMenuBurgerButtonLocator().click();
        return new BurgerMenuBarPage(driver);
    }

    public BasketPage clickOnBasketButton() {
        getBasketButton().click();
        return new BasketPage(driver);
    }

    // verifications block
    public TopBarPage searchLineIsClean() {
        assertEquals("", getSearchInputLocator().getText());
        return this;
    }

    public TopBarPage addressMenuVerification(String address) {
        assertEquals(address, getAddressMenuLocator().getText());
        return this;
    }

    public TopBarPage pageIsOpened() {
        waitsService.waitForExist(searchInputLocator).isDisplayed();
        return this;
    }

    public TopBarPage basketNavbarNotifyBackgroundColorVerification(String background) {
        assertEquals(background, getBasketNavbarNotify().getCssValue("background-color"));
        return this;
    }

    public TopBarPage basketCounterNotification(String number) {
        assertEquals(number, getBasketButton().getText());
        return this;
    }
}
