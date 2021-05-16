package hellocucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.BasketPage;
import pages.MainPage;
import pages.ProductPage;

public class StepDefinitions {
    MainPage mainPage;
    ProductPage productPage;
    BasketPage basketPage;
    //Feature #1
    @Given("I login as non registered user on haircarepanda")
    public void i_login_as_non_registered_user_on_haircarepanda()  {
        mainPage = new MainPage();
    }

    @Given("I select category “gummies”")
    public void i_select_category_gummies() {
        productPage = mainPage.clickOnGummies();
        productPage.getiUnderstandButton().click();
    }

    @Given("I put cursor on product")
    public void i_put_cursor_on_product()  {
        productPage.moveToElement(productPage.getVeganGummies());
    }

    @When("I tap on “Buy now” button")
    public void i_tap_on_buy_now_button() {
        productPage.moveToElement(productPage.getBuyNow());
        productPage.clickOnBuyNow();
        basketPage = productPage.clickOnBasketButton();
    }

    @Then("the basket page is displayed with selected previously product")
    public void the_basket_page_is_displayed_with_selected_previously_product() {
        Assert.assertEquals(basketPage.getCurrentUrl(), "https://haircarepanda.com/shopping-cart");
        Assert.assertTrue(basketPage.getVeganGummies().isDisplayed());
    }

    //Feature #2
    @Given("I add product to basket")
    public void i_add_product_to_basket() {
        productPage = mainPage.clickOnGummies();
        productPage.addGummiesToBasket();
}

    @Given("I navigate to basket")
    public void i_navigate_to_basket() {
       basketPage = productPage.clickOnBasketButton();
}
    @When("I tap on “delete” icon near product name")
    public void i_tap_on_delete_icon_near_product_name() {
        basketPage.clickOnDeleteFromBasket();
        basketPage.alertAccept();
    }

    @Then("the message “Your shopping cart is empty An empty basket is a sad basket” is displayed")
    public void the_message_your_shopping_cart_is_empty_an_empty_basket_is_a_sad_basket_is_displayed() {
        Assert.assertTrue(basketPage.getEmptyBasketMessage().isDisplayed());
        Assert.assertTrue(basketPage.getEmptyBasketMessageItsSad().isDisplayed());
    }

    //Feature #3
    @When("I tap on “+” icon near product name")
    public void i_tap_on_plus_icon_near_product_name() {
        basketPage.increaseQuantityOfProduct();
    }
    @Then("the quantity of products is increased")
    public void the_quantity_of_products_is_increased() {
        Assert.assertTrue(basketPage.getQuantityOfProductInBasket().isDisplayed());
        String expectedQuantity = "2";
        String actualQuantity = basketPage.getQuantityOfProductInBasket().getAttribute("value");
        System.out.println("expectedQuantity "+expectedQuantity+" actualQuantity "+actualQuantity);
        Assert.assertTrue("the number of items in the cart does not match"
                                    ,actualQuantity.equalsIgnoreCase(expectedQuantity));
    }

    @Then("the price is calculated correctly")
    public void the_price_is_calculated_correctly() {
        String expectedTotalPrice = "71,00 $"; //здесь тест упадет. Некорректная итоговая цена
        String actualTotalPrice = basketPage.getTotalPriceInBasket().getText();
        System.out.println("expectedTotalPrice "+expectedTotalPrice+" actualTotalPrice "+actualTotalPrice);
        Assert.assertTrue("the total amount of the item does not match the amount specified in the cart"
                                    ,actualTotalPrice.equalsIgnoreCase(expectedTotalPrice));
    }
}
