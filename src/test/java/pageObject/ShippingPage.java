package pageObject;

import helper.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingPage extends BasePage {

    @FindBy(css = "button.button:nth-child(4)")
    private WebElement proceedToCheckOutButton;

    @FindBy(id = "cgv")
    private WebElement termsOfServiceCheckBox;

    @FindBy(css = ".fancybox-item")
    private WebElement closeErrorPopup;

    public ShippingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnProceedToCheckOut (){
        proceedToCheckOutButton.click();
    }

    public void  clickOnTermsOfServiceCheckBox (){
        termsOfServiceCheckBox.click();
    }
    public void closeOnErrorPopup(){
        closeErrorPopup.click();
    }
}
