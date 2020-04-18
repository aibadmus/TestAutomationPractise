package helper;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends DriverFactory {

    @Before
    public void initDriver() {
        openChrome();
    }
    @After
    public void closeDriver(){
        driver.quit();
    }

}
