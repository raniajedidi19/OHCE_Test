package runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



    @RunWith(Cucumber.class)
    @CucumberOptions(
            features = "src/test/java/features",
            glue = "stepsDefinitions",
            tags = "@functional",
            plugin = {"pretty", "html:target/reports/report.html",
                    "json:target/reports/report.json"},
            dryRun = false)



public class TestRunner {


}
