package stepdefinition;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.pageobjects.shoppingPage;

import java.io.IOException;

public class stepDefinition extends shoppingPage {

    String productName=null;
    public stepDefinition() throws IOException {
    }

    @Given("^I add four different product to my wishlist$")
    public void addFourDifferentProduct() throws InterruptedException {
        addFourProducts();
    }

    @When("^I view my wishlist table$")
    public void viewMyWishListTable() throws InterruptedException {
        viewWishList();
    }

    @Then("^I find total four selected item in my Wishlist$")
    public void findFourSelectedItemInWishLiST() throws InterruptedException {
        itemcount();
    }

    @When("^I search for lowest price product$")
    public void searchLowestPriceItem()
    {
        productName=searchLowestPrice();
    }

    @And("^I am able to add my lowest price item to my cart$")
    public void addLowestItemToCart() throws InterruptedException {
        addLowestPriceItemToCart(productName);
    }

    @Then("^I am able to verify the item in my cart$")
    public void verifyItemInCart() throws InterruptedException {
        clickCart(productName);
    }
}
