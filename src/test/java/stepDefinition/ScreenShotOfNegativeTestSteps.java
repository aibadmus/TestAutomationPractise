package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pageObject.*;

public class ScreenShotOfNegativeTestSteps extends BaseStepDefs {
    WebDriver driver;


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
