package pageObject;

import helper.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class ProductPage extends BasePage {

    @FindBy(css= ("#group_1"))
    private WebElement sizeDropDown;

    @FindBy(css =(".exclusive"))
    private  WebElement addToCartButton;

    @FindBy(css = (".continue > span:nth-child(1)"))
    private WebElement contiuneShoppingButton;

    @FindBy(css = (".sf-menu > li:nth-child(1)"))
    private  WebElement womenTab;

    @FindBy(css = ("a.btn:nth-child(2)"))
    private WebElement proceedToCheckOut;

    @FindBy(css = ("#product_2_9_0_0"))
    private WebElement item1SizeLocator;

    @FindBy(css = ("#product_3_13_0_0"))
    private  WebElement item2SizeLocator;

    @FindBy(id = ("product_price_2_9_0"))
    private  WebElement item1PriceLocator;

    @FindBy(id = ("product_price_3_13_0"))
    private WebElement item2PriceLocator;

    @FindBy(id = ("total_product"))
    private  WebElement productTotalLocator;

    @FindBy(id =("total_price_without_tax"))
    private WebElement totalWithTax;

    @FindBy(id =("total_shipping"))
    private WebElement shippingCostId;

    @FindBy(css =(".standard-checkout"))
    private  WebElement checkOutButton;

    @FindBy(css = "#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a")
    private  WebElement shoppingCartDropDown;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void changeSizeToMedium() {
        Select medium = new Select(sizeDropDown);
        medium.selectByVisibleText("M");

    }

    public void addItemToCart() {
        addToCartButton.click();

    }
    public  void clickContinueShopping () {
        contiuneShoppingButton.click();
    }
    public void changeFocusToPopup () {
        driver.switchTo().frame(driver.findElement(By.className("fancybox-iframe")));

    }
    public void clickProceedToCheckOut () {
        proceedToCheckOut.click();

    }

    //        public String getItemSize(){
    //            String itemSize = item1SizeLocator.getAttribute("innerHTML");
    //            System.out.println(itemSize.contains("Size : M"));
    ////            return itemSize;

    //        }



    public String verifyItem1Size() {
        String itemSize = item1SizeLocator.getAttribute("innerHTML");
        System.out.println(itemSize.contains("Size : M"));
        System.out.println("Size : M");
        return itemSize;

    }

    public String verifyItem2Size() {
        String itemSize = item2SizeLocator.getAttribute("innerHTML");
        System.out.println(itemSize.contains("Size : S"));
        return itemSize;

    }

    public void verifyItem1Price() {
        Assert.assertTrue(item1PriceLocator.getText().contains("$27.00"));
    }

    public void verifyItem2Price() {
        Assert.assertTrue(item2PriceLocator.getText().contains("$26.00"));

    }
    public  void clickOnCheckOutButton(){
        checkOutButton.click();
    }
    public  void clickOnShoppingCart(){
        shoppingCartDropDown.click();
    }


    public void verifyItem1Amount(String item1Cost) {
        String item1PriceInCart = item1PriceLocator.getAttribute("innerHTML");
        Assert.assertTrue(item1PriceInCart.trim().contentEquals(item1Cost));
    }

    public void verifyItem2Amount(String item2Cost) {
        String item1PriceInCart = item2PriceLocator.getAttribute("innerHTML");
        Assert.assertTrue(item1PriceInCart.trim().contentEquals(item2Cost));
    }


    public void verifyTotalProducts(Double totalItemAmount) {
        String totalProductPrice = productTotalLocator.getAttribute("innerHTML");
        String orderAmount = "$"+String.valueOf(totalItemAmount);
        Assert.assertTrue(totalProductPrice.contentEquals(orderAmount));
        // TODO Auto-generated method stub

    }


    public void verifyTotal() {
        String total = productTotalLocator.getAttribute("innerHTML");
        String totalProductPrice = totalWithTax.getAttribute("innerHTML");
        String shippingCost = shippingCostId.getAttribute("innerHTML");
        Double calcTotal = ((Double.parseDouble(shippingCost.substring(1)))+(Double.parseDouble(totalProductPrice.substring(1))));
        calcTotal = Math.round(calcTotal*100)/100.0d;
        String calcTotalAmount = "$"+String.valueOf(calcTotal);
        Assert.assertTrue(total.contentEquals(calcTotalAmount));
    }

}

//
//    public void verifyTotal() {
//        String total = driver.findElement(totalExclTaxLocator).getAttribute("innerHTML");
//        String totalProductPrice = driver.findElement(totalProductPriceLocator).getAttribute("innerHTML");
//        String shippingCost = driver.findElement(shippingCostLocator).getAttribute("innerHTML");
//        Double calcTotal = ((Double.parseDouble(shippingCost.substring(1)))+(Double.parseDouble(totalProductPrice.substring(1))));
//        calcTotal = Math.round(calcTotal*100)/100.0d;
//        String calcTotalAmount = "$"+String.valueOf(calcTotal);
//        Assert.assertTrue(total.contentEquals(calcTotalAmount));
//    }







    //    driver.findElement(By.xpath("//span[contains(@title,'Continue shopping')]")).click();


//        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
//        driver.findElement(By.xpath(".//*[text()='Add to cart']")).click();





