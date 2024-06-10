package tests;

import baseEntities.BaseTest;
import org.junit.jupiter.api.Test;
import pages.TopBarPage;

public class FiltersPageTest extends BaseTest {
    String firstItemInMenu = "Электроника";
    String secondItemInMenu = "Ноутбуки и компьютеры";
    String thirdItemInMenu = "Ноутбуки";
    String priceStartIn = "100 000";
    String priceEnd = "149 000";
    String radioButtonName = "до 3 дней";
    String firstCheckboxName = "Apple";
    String secondCheckboxName = "15.3\"";
    String counterValue = "4";

    @Test
    public void workWithFilters() throws InterruptedException {
        new TopBarPage(driver)
                .clickOnjBurgerMenuButton()
                .clickOnMainMenuByName(firstItemInMenu)
                .clickOnDropMenuByName(secondItemInMenu)
                .lastClickOnDropdownMenuAndGoToCatalogByName(thirdItemInMenu)
                .pageIsOpened()
                .clickOnFilterButton()
                .clearAndInputStartInPrice(priceStartIn)
                .clearAndInputEndPrice(priceEnd)
                .clickOnRadioAndCheckboxButton(radioButtonName)
                .clickOnRadioAndCheckboxButton(firstCheckboxName)
                .clickOnRadioAndCheckboxButton(secondCheckboxName)
                .clickOnShowButton()
                .allFiltersCounterVerification(counterValue)
                .productCounterVerification()
                .filtersChoiceListVerification(radioButtonName, firstCheckboxName, "от " + priceStartIn + " до " + priceEnd,secondCheckboxName,"Сбросить все");
    }
}
