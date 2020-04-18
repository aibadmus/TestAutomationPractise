package pageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    WebDriver driver;

    @FindBy(id = ".login")
    private WebElement signInButton;

    @FindBy(css = ("#homefeatured > li:nth-child(2) > div > div.left-block > div > a.product_img_link > img"))
    private WebElement blouseQuickView;

    @FindBy(css = "#homefeatured > li:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1)")
    private WebElement printedDress1;

    @FindBy(how = How.CLASS_NAME, className = "header_user_info")
    private WebElement resultsWebPart;

    public HomePage(WebDriver driver) {
        this.driver =driver;
        PageFactory.initElements(driver, this);
    }

    public void clickBlouseQuickView () {
        blouseQuickView.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.and(ExpectedConditions.visibilityOf(driver.findElement(By.className("fancybox-iframe")))));
    }
    public void selectPrintedDress1 () throws Exception{
        printedDress1.click();
        Thread.sleep(3000);
    }
    public boolean verifyIfSignedIn() {
        if(resultsWebPart.getAttribute("class").contains("logout")) {
            return true;
        } else {
            return false;
        }
    }
}
