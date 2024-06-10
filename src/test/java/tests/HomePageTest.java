package tests;


import baseEntities.BaseTest;
import org.junit.jupiter.api.Test;
import pages.TopBarPage;

public class HomePageTest extends BaseTest {
    String searchProduct = "Iphone 13";
    String expectedText = "По запросу Iphone 13 найдено";
    String filterName = "По популярности";
    String productLabelName="Apple";

    @Test
    public void forkWithSearchLineTest() {
        new TopBarPage(driver)
                .searchProduct(searchProduct)
                .searchingResultsVerification(searchProduct)
                .firstFilterVerification("")
                .secondFilterVerification(filterName)
                .firstProductCardLabelVerification(productLabelName);

        new TopBarPage(driver).clearSearchLine().searchLineIsClean();
    }
}
