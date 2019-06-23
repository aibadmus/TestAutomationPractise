package pageObject;

import helper.BasePage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.io.File;
import org.apache.commons.io.FileUtils;


public class MyAccountPage extends BasePage {

    @FindBy(css = ".sf-menu > li:nth-child(1)")
    private WebElement WomenTab;

    @FindBy(css = ".sf-menu > li:nth-child(2)")
    private WebElement DressTab;

    @FindBy(css = ".sf-menu > li:nth-child(3)")
    private WebElement TShirtTab;

    @FindBy(css = "div.col-sm-6:nth-child(1) > ul:nth-child(1) > li:nth-child(1) > a:nth-child(1) > span:nth-child(2)")
    private  WebElement orderHistoryAndDetailsButton;

    @FindBy(css = "tr.first_item > td:nth-child(2)")
    private WebElement previousOrderDate;

    @FindBy(css = "tr.first_item > td:nth-child(7) > a:nth-child(1) > span:nth-child(1)")
    private WebElement orderDetail1Button;

    @FindBy(css = "textarea.form-control")
    private WebElement addMessageToOrderTextField;

    @FindBy(css = "button.button:nth-child(3) > span:nth-child(1)")
    private WebElement sendMessageOnPreviousOrderButton;

    @FindBy(css = "div.table_block:nth-child(9) > table:nth-child(1)")
    private  WebElement previousOrderMessageHistorySection;

    @FindBy(css = "tr.first_item > td:nth-child(7) > a:nth-child(2)")
    private WebElement reorderPreviousOrderButton;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickWomenTab() {
        WomenTab.click();
    }
    public void clickOrderHistoryAndDetails (){
        orderHistoryAndDetailsButton.click();
    }
    public void verifyPreviousOrderDate () {
        Assert.assertTrue(previousOrderDate.getText().contains("06/23/2019"));
    }
    public void clickOrderDetails1 (){
        orderDetail1Button.click();
    }
    public void enterMessageForPreviousOrder (){
        addMessageToOrderTextField.sendKeys("This is a test for a brilliant job");

    }
    public void clickOnSendButtonForMessage(){
        sendMessageOnPreviousOrderButton.click();

    }
    public void verifyPreviousOrdermessage(){
        Assert.assertTrue(previousOrderMessageHistorySection.getText().contains("This is a test for a brilliant job"));
    }
    public void clickOnReorderButton(){
        reorderPreviousOrderButton.click();
    }
    public void takeScreenshotOfPage() throws  Exception{
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "//src//main//resources//screenShots//screenshot.png"));

    }
}
