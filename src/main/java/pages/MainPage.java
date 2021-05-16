package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverProvider;
import java.time.Duration;


public class MainPage extends AbstractPage{
    public MainPage() {
        super();
        waitForLoadableElement();
    }

    @FindBy(css = ".mrow a[href$=\"zelki\"]")
    WebElement gummies;

    public ProductPage clickOnGummies(){
        getGummies().click();
        return new ProductPage();
    }

    public WebElement getGummies() {
        return gummies;
    }

    @Override
    public void waitForLoadableElement(){
        WebElement explicitWait = (new WebDriverWait(DriverProvider.INSTANCE.getDriver(), Duration.ofSeconds(10)))
                .until(ExpectedConditions.visibilityOf(getGummies()));
    }
}
