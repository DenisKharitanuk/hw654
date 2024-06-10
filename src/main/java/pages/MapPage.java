package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapPage extends BasePage {
    //locators block
    private By placeHolderLocator = By.xpath("//input[@placeholder='Введите адрес'][@autocomplete='off']");
    private By addressLocator = By.xpath("//span[@class='address-item__name-text']/span");
    private By selectButtonLocator = By.className("details-self__btn");
    private By pickUpPointerNameLocator = By.className("details-self__name-text");


    public MapPage(WebDriver driver) {
        super(driver);
    }

    //getters block
    private WebElement getPickUpPointerNames() {
        return waitsService.waitForVisibilityBy(pickUpPointerNameLocator);
    }

    private WebElement getPlaceHolder() {
        return waitsService.waitForExist(placeHolderLocator);
    }

    private WebElement getSelectButton() {
        return waitsService.waitForVisibilityBy(selectButtonLocator);
    }

    private List<WebElement> getAddress() {
        return waitsService.waitForAllForExistLocated(addressLocator);
    }


    //selector locators block
    private WebElement selectAddressByIndex(int index) {
        List<WebElement> addresesLocatorList = new ArrayList<>(getAddress());
        return addresesLocatorList.get(index);
    }

    // actions block
    public MapPage inputAddress(String address) {
        getPlaceHolder().sendKeys(address, Keys.ENTER);
        return this;
    }

    public MapPage selectOnAddressByIndex(int index) {
        selectAddressByIndex(index).click();
        return this;
    }

    public TopBarPage clickOnSelectButtonLocator() {
        getSelectButton().click();
        return new TopBarPage(driver);
    }


    // verifications block
    public MapPage pickUpPointByIndexVerification(int index) {
        assertEquals(selectAddressByIndex(index).getText(), getPickUpPointerNames().getText());
        return this;
    }
}
