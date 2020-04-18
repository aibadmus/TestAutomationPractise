package helper;

import cucumber.api.java.After;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public static WebDriver driver;

    public void openChrome()  {
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "//src//main//resources//drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/");
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

    }

    public void scrollDown (){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

    }


}
