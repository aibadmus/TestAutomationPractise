package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import pageObject.*;

public class Purchase2ItemsSteps extends BaseStepDefs{

    @Given("^I am successfully signed in$")
    public void i_am_successfully_signed_in() {
        Assert.assertFalse(homePage.verifyIfSignedIn());
    }

    @Given("^I 'Quick view’ an item$")
    public void i_Quick_view_an_item() throws Throwable  {
        homePage.clickBlouseQuickView();
    }

    @When("^I Change the size of the item$")
    public void i_Change_the_size_of_the_item() throws Throwable {
        productPage.changeFocusToPopup();
        productPage.changeSizeToMedium();
    }

    @When("^I Add that item to my basket$")
    public void i_Add_that_item_to_my_basket() {
        productPage.addItemToCart();
        productPage.clickContinueShopping();
    }

    @When("^I ‘Quick view’ a different item \\(leave the size at the default\\)$")
    public void i_Quick_view_a_different_item_leave_the_size_at_the_default() throws Throwable {
        homePage.selectPrintedDress1();
    }

    @When("^I Add the item to my basket$")
    public void i_Add_the_item_to_my_basket() {
        productPage.changeFocusToPopup();
        productPage.addItemToCart();
        productPage.clickProceedToCheckOut();
    }

    @When("^I View the basket to confirm that the items are of the size you selected,$")
    public void i_View_the_basket_to_confirm_that_the_items_are_of_the_size_you_selected() {
        productPage.verifyItem1Size();
        productPage.verifyItem2Size();
    }

    @When("^I check that their prices are correct,$")
    public void i_check_that_their_prices_are_correct() {
        productPage.verifyItem1Price();
        productPage.verifyItem2Price();
    }

    @When("^I Check that Total amount includes the Products with the Shipping cost$")
    public void i_Check_that_Total_amount_includes_the_Products_with_the_Shipping_cost() {
//        productPage = new ProductPage(driver);
//        productPage.verifyItem1Amount("item1Cost");
//        productPage.verifyItem2Amount("item2Cost");
//        productPage.verifyTotalProducts();
    }

    @When("^I Proceed through checkout to payment$")
    public void i_Proceed_through_checkout_to_payment() {
        productPage.clickOnCheckOutButton();
        signInPage.Login();
        productPage.clickOnShoppingCart();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        signInPage.clickOnProceedToCheckOUt();
        addressPage.clickProceedToCheckOutButton();
        shippingPage.clickOnTermsOfServiceCheckBox();
        shippingPage.clickOnProceedToCheckOut();
        paymentPage.selectBankWirePayment();
        paymentPage.clickOnConfirmOrder();
        paymentPage.clickOnSignOutButton();
    }

    @Then("^I should get a confirmation that my transaction is completed$")
    public void i_should_get_a_confirmation_that_my_transaction_is_completed() {
        // Write code here that turns the phrase above into concrete actions
    }

    @And("^I click on the reorder button$")
    public void iClickOnTheReorderButton() throws Throwable {
        myAccountPage.clickOnReorderButton();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        signInPage.clickOnProceedToCheckOUt();
        addressPage.clickProceedToCheckOutButton();
        shippingPage.clickOnProceedToCheckOut();
        myAccountPage.takeScreenshotOfPage();
        paymentPage.clickOnSignOutButton();
    }

    @Then("^I should get an error popup$")
    public void iShouldGetAnErrorPopup()throws Throwable {
        myAccountPage.takeScreenshotOfPage();
        paymentPage.clickOnSignOutButton();
    }
}
