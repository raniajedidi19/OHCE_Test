package runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


    @RunWith(Cucumber.class)
    @CucumberOptions(
            features = "src/test/java/features/smokeTests.feature",
            glue = "stepsDefinitions",
            tags = "@functional",
            plugin = {"pretty",
                    "json:target/reports/report.json",
                    "html:target/reports/report.html",
                    "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
            dryRun = false)

public class TestRunner {
}
