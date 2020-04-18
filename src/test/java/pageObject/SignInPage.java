package pageObject;

import helper.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
  WebDriver driver;


  @FindBy(css= (".login"))
    private WebElement signinButton;

  @FindBy(css = "#email")
    private  WebElement emailTextField;

  @FindBy(id = "passwd")
    private  WebElement passwordTextField;

  @FindBy(id = "SubmitLogin")
  private  WebElement submitLogin;

  @FindBy(css = ".standard-checkout > span:nth-child(1)")
  private WebElement proceedToCheckOutButton;

  public SignInPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void Login (){
    signinButton.click();
    emailTextField.sendKeys("got@gmail.com");
    passwordTextField.sendKeys("BJSSTest");
    submitLogin.click();

  }
  public void clickOnProceedToCheckOUt (){
    proceedToCheckOutButton.click();

  }

    }



