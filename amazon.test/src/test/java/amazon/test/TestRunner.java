package amazon.test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
 features = "src/test/resources/features"
 ,glue={"amazon.test"},
 plugin = { "pretty", "json:target/Cucumber.json" },
 monochrome = true
)
public class TestRunner {

}
