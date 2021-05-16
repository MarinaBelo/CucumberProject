package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Waiters {
    public WebElement waitForElementToBeVisible(WebElement webElement) {
        return (new WebDriverWait(DriverProvider.INSTANCE.getDriver(), Duration.ofSeconds(10)))
                .until(ExpectedConditions.visibilityOf(webElement));
    }
}
