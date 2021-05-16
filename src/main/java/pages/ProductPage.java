package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverProvider;

import java.time.Duration;

public class ProductPage extends AbstractPage {
    public ProductPage() {
        super();
        waitForLoadableElement();
    }

    @FindBy(css = "a[href$=\"vegan-gummies\"]")
    WebElement veganGummies;
    @FindBy(css = "button[onclick*=\"setLocalCookie\"]")
    WebElement iUnderstandButton;
    @FindBy(css = "span[data-id=\"1227\"]")
    WebElement buyNow;
    @FindBy(xpath = "//td[@class=\"name-cell\"]")
    WebElement productTitleInBasket;
    @FindBy(css = ".table-cart-small-footer")
    WebElement basketButton;

    public void moveToElement  (WebElement webElement){
        Actions action = new Actions(DriverProvider.INSTANCE.getDriver());
        action.moveToElement(webElement);
        action.perform();
    }

    public void addGummiesToBasket(){
        getiUnderstandButton().click();
        moveToElement(getVeganGummies());
        moveToElement(getBuyNow());
        clickOnBuyNow();
        moveToElement(getBasketButton());
    }

    public void clickOnBuyNow(){
        getBuyNow().click();
    }

    public void clickOnIUnderstandButton(){
        getiUnderstandButton().click();
    }

    public BasketPage clickOnBasketButton(){
        getBasketButton().click();
        return new BasketPage();
    }

    public WebElement getVeganGummies() {
        return veganGummies;
    }

    public WebElement getBuyNow() {
        return buyNow;
    }

    public WebElement getiUnderstandButton() {
        return iUnderstandButton;
    }

    public WebElement getBasketButton() {
        return basketButton;
    }

    @Override
    public void waitForLoadableElement() {
        WebElement explicitWait = (new WebDriverWait(DriverProvider.INSTANCE.getDriver(), Duration.ofSeconds(10)))
                .until(ExpectedConditions.visibilityOf(getVeganGummies()));
    }

}
