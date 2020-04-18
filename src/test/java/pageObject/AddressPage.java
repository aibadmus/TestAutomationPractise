package pageObject;

import helper.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage {
    WebDriver driver;

    @FindBy(css = "button.button:nth-child(4) > span:nth-child(1)")
    private WebElement proceedToCheckOutButton;


    public AddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
   public void clickProceedToCheckOutButton (){
       proceedToCheckOutButton.click();

    }
}
