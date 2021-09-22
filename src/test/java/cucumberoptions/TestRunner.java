package cucumberoptions;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = {"stepdefinition"},
        plugin = { "pretty", "html:target/cucumber-reports" },
        monochrome = true
)

public class TestRunner {
}
