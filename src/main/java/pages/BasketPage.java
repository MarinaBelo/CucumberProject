package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverProvider;

import java.time.Duration;

public class BasketPage extends AbstractPage{
    public BasketPage() {
        super();
        waitForLoadableElement();
    }

    @FindBy(css = "a[href$=\"vegan-gummies\"]")
    WebElement veganGummies;
    @FindBy(css = ".text-center.biger-text.hidden-xs>.delete")
    WebElement deleteFromBasket;
    @FindBy(xpath = "//span[text()[contains(.,'Your shopping cart is empty')]]")
    WebElement emptyBasketMessage;
    @FindBy(xpath = "//span[text()[contains(.,'An empty basket is a sad basket.')]]")
    WebElement emptyBasketMessageItsSad;
    @FindBy(css = ".plus")
    WebElement increaseQuantityOfProduct;
    @FindBy(css = ".quantity-box>[value=\"2\"]")
    WebElement quantityOfProductInBasket;
    @FindBy(xpath = "//*[@class=\"text-center pull-right\"]//span[text()[contains(.,'76,00')]]")
    WebElement totalPriceInBasket;

    public WebElement getVeganGummies() {
        return veganGummies;
    }

    public void clickOnDeleteFromBasket(){
        getDeleteFromBasket().click();
    }

    public WebElement getDeleteFromBasket() {
        return deleteFromBasket;
    }

    public WebElement getEmptyBasketMessage() {
        return emptyBasketMessage;
    }

    public WebElement getEmptyBasketMessageItsSad() {
        return emptyBasketMessageItsSad;
    }

    public WebElement getIncreaseQuantityOfProduct() {
        return increaseQuantityOfProduct;
    }

    public WebElement getQuantityOfProductInBasket() {
        return quantityOfProductInBasket;
    }

    public WebElement getTotalPriceInBasket() {
        return totalPriceInBasket;
    }

    public void increaseQuantityOfProduct (){
        getIncreaseQuantityOfProduct().click();
    }

    public String getCurrentUrl (){
        return DriverProvider.INSTANCE.getDriver().getCurrentUrl();
    }

    public void alertAccept (){
        Alert alert = DriverProvider.INSTANCE.getDriver().switchTo().alert();
        alert.accept();
    }

    @Override
    public void waitForLoadableElement() {
        WebElement explicitWait = (new WebDriverWait(DriverProvider.INSTANCE.getDriver(), Duration.ofSeconds(10)))
                .until(ExpectedConditions.visibilityOf(getVeganGummies()));
    }
}
