package tests;

import baseEntities.BaseTest;
import org.junit.jupiter.api.Test;
import pages.CatalogPage;
import pages.TopBarPage;

public class BasketPageTest extends BaseTest {
    String firstItemInMenu = "Бытовая техника";
    String secondItemInMenu = "Техника для дома";
    String thirdItemInMenu = "Пылесосы и пароочистители";
    String fourthItemInMenu = "Вертикальные пылесосы";
    String color = "rgba(245, 81, 35, 1)";
    String basketCounter = "1";
    String price = "2 345 ₽";
    String totalPrice = "2 345 ₽";
    String productCardInfo = "Вертикальный ручной Пылесос для дома с контейнером, Deerma";

    @Test
    public void addProductToBasketTest() throws InterruptedException {
        new TopBarPage(driver)
                .clickOnjBurgerMenuButton()
                .clickOnMainMenuByName(firstItemInMenu)
                .clickOnDropMenuByName(secondItemInMenu)
                .clickOnDropMenuByName(thirdItemInMenu)
                .lastClickOnDropdownMenuAndGoToCatalogByName(fourthItemInMenu)
                .pageIsOpened()
                .catalogTitleVerification(fourthItemInMenu)
                .breadcrumbsLinksVerification("Главная", firstItemInMenu,
                        secondItemInMenu, thirdItemInMenu, fourthItemInMenu)
                .clickOnAddToBasketButton()
                .basketNavbarNotifyBackgroundColorVerification(color)
                .basketCounterNotification(basketCounter)
                .clickOnBasketButton()
                .productInfoVerification(productCardInfo)
                .productPricesVerification(price)
                .totalPriceVerification(totalPrice)
                .toOrderButtonIsClicable();
    }
}
