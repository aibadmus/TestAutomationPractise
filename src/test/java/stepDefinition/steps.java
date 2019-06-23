package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import  org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.*;
import helper.BasePage;

import java.util.concurrent.TimeUnit;


public class steps {
    WebDriver driver;
    BasePage basePage;
    MainPage mainPage;
    ProductPage productPage;
    SignInPage signInPage;
    MyAccountPage myAccountPage;
    AddressPage addressPage;
    ShippingPage shippingPage;
    PaymentPage paymentPage;


    @Given("^I am successfully signed in$")
    public void i_am_successfully_signed_in() throws Throwable {
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "//src//main//resources//drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/");


    }

    @Given("^I 'Quick view’ an item$")
    public void i_Quick_view_an_item() throws Throwable {
        mainPage = new MainPage(driver);
        mainPage.clickBlouseQuickView();
        Thread.sleep(1000);


    }

    @When("^I Change the size of the item$")
    public void i_Change_the_size_of_the_item() throws Throwable {
        productPage = new ProductPage(driver);
        productPage.changeFocusToPopup();
        productPage.changeSizeToMedium();
        Thread.sleep(1000);

    }

    @When("^I  Add that item to my basket$")
    public void i_Add_that_item_to_my_basket() throws Throwable {
        productPage = new ProductPage(driver);
        productPage.addItemToCart();
        Thread.sleep(3000);


    }

    @When("^I Continue shopping$")
    public void i_Continue_shopping() throws Throwable {
        productPage = new ProductPage(driver);
        productPage.clickContinueShopping();
        Thread.sleep(3000);

    }

    @When("^I ‘Quick view’ a different item \\(leave the size at the default\\)$")
    public void i_Quick_view_a_different_item_leave_the_size_at_the_default() throws Throwable {
        mainPage = new MainPage(driver);
        mainPage.selectPrintedDress1();

    }

    @When("^I Add the item to my basket$")
    public void i_Add_the_item_to_my_basket() throws Throwable {
        productPage = new ProductPage(driver);
        productPage.changeFocusToPopup();
        productPage.addItemToCart();
        Thread.sleep(3000);
        productPage.clickProceedToCheckOut();

    }

    @When("^I View the basket to confirm that the items are of the size you selected,$")
    public void i_View_the_basket_to_confirm_that_the_items_are_of_the_size_you_selected() throws Throwable {
        productPage = new ProductPage(driver);
        productPage.verifyItem1Size();
        productPage.verifyItem2Size();
    }

    @When("^I check that their prices are correct,$")
    public void i_check_that_their_prices_are_correct() throws Throwable {
        productPage = new ProductPage(driver);
        productPage.verifyItem1Price();
        productPage.verifyItem2Price();

    }

    @When("^I Check that Total amount includes the Products with the Shipping cost$")
    public void i_Check_that_Total_amount_includes_the_Products_with_the_Shipping_cost() throws Throwable {
//        productPage = new ProductPage(driver);
//        productPage.verifyItem1Amount("item1Cost");
//        productPage.verifyItem2Amount("item2Cost");
//        productPage.verifyTotalProducts();


    }

    @When("^I Proceed through checkout to payment$")
    public void i_Proceed_through_checkout_to_payment() throws Throwable {
        productPage = new ProductPage(driver);
        productPage.clickOnCheckOutButton();
        Thread.sleep(3000);
        signInPage = new SignInPage(driver);
        signInPage.Login();
        productPage.clickOnShoppingCart();
        addressPage = new AddressPage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(3000);
        signInPage.clickOnProceedToCheckOUt();
        Thread.sleep(3000);
        addressPage.clickProceedToCheckOutButton();
        shippingPage = new ShippingPage(driver);
        shippingPage.clickOnTermsOfServiceCheckBox();
        shippingPage.clickOnProceedToCheckOut();
        paymentPage = new PaymentPage(driver);
        paymentPage.selectBankWirePayment();
        paymentPage.clickOnConfirmOrder();
        paymentPage.clickOnSignOutButton();

    }

    @Then("^I should get a confirmation that my transaction is completed$")
    public void i_should_get_a_confirmation_that_my_transaction_is_completed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @Given("^I am successfully signed in with my details$")
    public void iAmSuccessfullySignedInWithMyDetails() {
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "//src//main//resources//drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/");
        signInPage = new SignInPage(driver);
        signInPage.Login();
    }


    @And("^I go to my order history and details$")
    public void iGoToMyOrderHistoryAndDetails() {
        myAccountPage = new MyAccountPage(driver);
        myAccountPage.clickOrderHistoryAndDetails();

    }

    @Then("^I can see my previous orders$")
    public void iCanSeeMyPreviousOrders() {

    }

    @Then("^I can confirm the date of purchase of previous order$")
    public void iCanConfirmTheDateOfPurchaseOfPreviousOrder() {
        myAccountPage = new MyAccountPage(driver);
        myAccountPage.verifyPreviousOrderDate();

    }

    @And("^I add a comment$")
    public void iAddAComment()throws Throwable {
        myAccountPage = new MyAccountPage(driver);
        myAccountPage.clickOrderDetails1();
        myAccountPage.enterMessageForPreviousOrder();
        Thread.sleep(2000);
        myAccountPage.clickOnSendButtonForMessage();
        Thread.sleep(2000);
    }

    @Then("^I should be able to see the comment added$")
    public void iShouldBeAbleToSeeTheCommentAdded() throws Throwable {
        myAccountPage = new MyAccountPage(driver);
        myAccountPage.verifyPreviousOrdermessage();
        paymentPage = new PaymentPage(driver);
        paymentPage.clickOnSignOutButton();
    }

    @And("^I click on the reorder button$")
    public void iClickOnTheReorderButton() throws Throwable {
        myAccountPage = new MyAccountPage(driver);
        myAccountPage.clickOnReorderButton();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        signInPage = new SignInPage(driver);
        signInPage.clickOnProceedToCheckOUt();
        addressPage = new AddressPage(driver);
        addressPage.clickProceedToCheckOutButton();
        shippingPage = new ShippingPage(driver);
        shippingPage.clickOnProceedToCheckOut();
        myAccountPage.takeScreenshotOfPage();
        paymentPage = new PaymentPage(driver);
        paymentPage.clickOnSignOutButton();


    }

    @And("^I reorder an item without ticking the check box$")
    public void iReorderAnItemWithoutTickingTheCheckBox() {
        myAccountPage = new MyAccountPage(driver);
        myAccountPage.clickOnReorderButton();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        signInPage = new SignInPage(driver);
        signInPage.clickOnProceedToCheckOUt();
        addressPage = new AddressPage(driver);
        addressPage.clickProceedToCheckOutButton();
        shippingPage = new ShippingPage(driver);
        shippingPage.clickOnProceedToCheckOut();
    }

    @Then("^I should get an error popup$")
    public void iShouldGetAnErrorPopup()throws Throwable {
        myAccountPage = new MyAccountPage(driver);
        myAccountPage.takeScreenshotOfPage();
        paymentPage = new PaymentPage(driver);
        paymentPage.clickOnSignOutButton();
    }

    @Then("^I can take a screen shot of the error message$")
    public void iCanTakeAScreenShotOfTheErrorMessage() throws Throwable {
        myAccountPage = new MyAccountPage(driver);
        myAccountPage.takeScreenshotOfPage();
        shippingPage = new ShippingPage(driver);
        shippingPage.closeOnErrorPopup();
        paymentPage = new PaymentPage(driver);
        Thread.sleep(4000);
        paymentPage.clickOnSignOutButton();
    }
}
