package pages;

import org.openqa.selenium.support.PageFactory;
import utils.DriverProvider;

public abstract class AbstractPage {
    public AbstractPage() {
        PageFactory.initElements(DriverProvider.INSTANCE.getDriver(), this);
    }

    public abstract void waitForLoadableElement();
}