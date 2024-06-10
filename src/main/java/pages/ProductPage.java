package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends BasePage {
    private By addToBasketButtonLocator = By.cssSelector(".product-page__aside .order__for-fixed");
    private By basketButtonLocator = By.cssSelector(".navbar-pc__icon.navbar-pc__icon--basket");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getAddToBasketButtonLocator() {
        return driver.findElement(addToBasketButtonLocator);
    }

    public WebElement getBasketButtonLocator() {
        return driver.findElement(basketButtonLocator);
    }
}
