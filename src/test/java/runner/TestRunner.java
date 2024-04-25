package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.Test;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepDefinition",
        monochrome = true,
        plugin= {"pretty", "html:target/cucumber-reports/TestRunner.html",
                "json:target/cucumber-reports/TestRunner.json"}
)
@Test
public class TestRunner extends AbstractTestNGCucumberTests {
}