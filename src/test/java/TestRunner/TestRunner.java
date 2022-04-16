package TestRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features",
        glue = {"StepDefinition"},
        plugin ={"pretty","html:target/site/cucumber-pretty","json:target/cucumber.json","junit:target/cucumber.xml"})

public class TestRunner {



}
