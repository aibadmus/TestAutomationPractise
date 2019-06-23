package runner;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features",
        glue = "stepDefinition",
        plugin = {
                "pretty",
                "html:target/cucumber",
        }
)
@Test
public class testRunner extends AbstractTestNGCucumberTests {
}
