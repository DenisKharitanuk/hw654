package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasketPage extends BasePage {
    //Locators block
    private By productLocator = By.cssSelector(".good-info__title.j-product-popup");
    private By productPriceCardLocator = By.cssSelector(".list-item__price-new.wallet");
    private By productPriceWithWBWalletLocator = By.className("list-item__price-wallet");
    private By totalPriceLocator = By.xpath("//p[@class='b-top__total line' ]/span/span");
    private By toOrderButtonLocator = By.className("b-btn-do-order");


    public BasketPage(WebDriver driver) {
        super(driver);
    }

    //getters block
    private WebElement getToOrderButton() {
        return waitsService.waitToBeClickableByLocator(toOrderButtonLocator);
    }

    private WebElement getProduct() {
        return waitsService.waitForExist(productLocator);
    }

    private WebElement getTotalPrice() {
        return waitsService.waitForExist(totalPriceLocator);
    }

    private WebElement getProductPrice() {
        return waitsService.waitForVisibilityBy(productPriceCardLocator);
    }

    private WebElement getProductPriceWithWBWallet() {
        return waitsService.waitForExist(productPriceWithWBWalletLocator);
    }

    //verifications block

    public BasketPage productInfoVerification(String infoText) {
        assertEquals(infoText, getProduct().getText());
        return this;
    }

    public BasketPage productPricesVerification(String price) {
        assertEquals(price, getProductPrice().getText());
        return this;
    }

    public BasketPage totalPriceVerification(String totalPrice) {
        assertEquals(totalPrice, getTotalPrice().getText());
        return this;
    }
    public BasketPage toOrderButtonIsClicable(){
        getToOrderButton();
        return this;
    }
}
