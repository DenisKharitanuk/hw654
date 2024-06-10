package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BurgerMenuBarPage extends BasePage {

    //locator block

    private By mainMenuLocator = By.className("menu-burger__main-list-link");
    private By dropMenuLocator = By.cssSelector(".menu-burger__link");


    public BurgerMenuBarPage(WebDriver driver) {
        super(driver);
    }


    //getters block
    private List<WebElement> getMainMenu() {
        return waitsService.waitForAllVisibleElementsLocatedBy(mainMenuLocator);
    }

    private List<WebElement> getDropMenu() {
        return waitsService.waitForAllVisibleElementsLocatedBy(dropMenuLocator);
    }

    //select locator block
    private WebElement selectMainMenuByMenuName(String menuName) {
        WebElement mainMenuElementByName = null;
        List<WebElement> mainMenuLocatorsList = new ArrayList<>(getMainMenu());
        for (WebElement element : mainMenuLocatorsList) {
            if (element.getText().equals(menuName)) {
                mainMenuElementByName = element;
                break;
            }
        }
        return mainMenuElementByName;
    }

    private WebElement selectDropMenuByMenuName(String menuName) {
        WebElement dropMenuElementByName = null;
        List<WebElement> dropMenuLocatorsList = new ArrayList<>(getDropMenu());
        for (WebElement element : dropMenuLocatorsList) {
            if (element.getText().equals(menuName)) {
                dropMenuElementByName = element;
                break;
            }
        }
        return  dropMenuElementByName;
    }


    //action block
    public BurgerMenuBarPage clickOnMainMenuByName(String menuName) {
        selectMainMenuByMenuName(menuName).click();
        return this;
    }

    public BurgerMenuBarPage clickOnDropMenuByName(String menuName) {
        selectDropMenuByMenuName(menuName).click();
        return this;
    }

    public CatalogPage lastClickOnDropdownMenuAndGoToCatalogByName(String menuName) {
        selectDropMenuByMenuName(menuName).click();
        return new CatalogPage(driver);
    }
}
