package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepDefinition",
        monochrome = true,
        plugin= {"pretty", "json:target/cucumber-reports/cucumber.json","html:target/cucumber-html-report"}
)
public class TestRunner {
}