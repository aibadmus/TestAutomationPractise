package helper;

import cucumber.api.java.After;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BasePage {

    public static WebDriver driver;

    public  String baseURL = "http://automationpractice.com/";


    public void openChrome(String url) throws Exception {
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "//src//main//resources//drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(url);
    }
    public void scrollDown (){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

    }

    @After
    public void teardown() {
        driver.quit();


    }

}
