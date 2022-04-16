package StepDefinition;

import POM.Patterns;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class NumViews {

    Patterns patterns = new Patterns();

    @Given("User Go To Patterns service api endpoint")
    public void userGoToPatternsServiceApiEndpoint() {
        patterns.BaseURL();
    }

    @Then("User Set Request Headers")
    public void userSetRequestHeaders() {
       patterns.SetRequestHeaders();
    }

    @Then("Verify numViews Values Greater Than 4000")
    public void verifyNumViewsValuesGreaterThan() {
       patterns.VerifyResponseValues();
    }



}

