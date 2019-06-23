package pageObject;


import helper.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MainPage extends BasePage {



    @FindBy(id = ".login")
    private WebElement signInButton;

    @FindBy(css = ("#homefeatured > li:nth-child(2) > div > div.left-block > div > a.product_img_link > img"))
    private WebElement blouseQuickView;

    @FindBy(css = "#homefeatured > li:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1)")
    private WebElement printedDress1;

    public MainPage(WebDriver driver) {
        this.driver =driver;
        PageFactory.initElements(driver, this);
    }

    public void clickBlouseQuickView (){
        blouseQuickView.click();
    }
    public void selectPrintedDress1 (){
        printedDress1.click();
    }
}
