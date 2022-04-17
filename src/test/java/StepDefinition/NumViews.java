package StepDefinition;

import POM.Patterns;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import java.io.IOException;

public class NumViews {
    SoftAssert softAssert = new SoftAssert();
    Patterns patterns = new Patterns();

    @Given("User Go To Patterns service api endpoint")
    public void userGoToPatternsServiceApiEndpoint() throws IOException {
        patterns.BaseURL();
    }

    @When("User Set Request Headers")
    public void userSetRequestHeaders() {
       patterns.SetRequestHeaders();
    }

    @Then("Verify numViews Values Greater Than {int}")
    public void verifyNumViewsValuesGreaterThan(int value) {
        for (int i=0;i<patterns.ValuesList().size();i++){
            softAssert.assertTrue(Integer.parseInt(patterns.ValuesList().get(i))>value);
        }
        softAssert.assertAll();
    }
}

