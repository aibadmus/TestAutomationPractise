package pageObject;

import helper.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage  {
    WebDriver driver;

    @FindBy(css = ".bankwire")
    private WebElement bankwirePaymentOption;

    @FindBy(css = "button.button-medium > span:nth-child(1)")
    private  WebElement confirmOrder;

    @FindBy(css = ".logout")
    private  WebElement signOutButton;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void selectBankWirePayment () {
        bankwirePaymentOption.click();
    }
    public void clickOnConfirmOrder () {
        confirmOrder.click();
    }
    public void clickOnSignOutButton () {
        signOutButton.click();
        driver.quit();
    }


}
