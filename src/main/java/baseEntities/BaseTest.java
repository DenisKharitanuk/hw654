package baseEntities;

import configuration.ReadProperties;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import services.BrowsersService;

public class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new BrowsersService().getDriver();
        driver.get(ReadProperties.getUrl());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
