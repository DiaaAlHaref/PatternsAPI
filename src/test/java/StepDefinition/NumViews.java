package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class NumViews {
    boolean flag;
    SoftAssert softAssert = new SoftAssert();
    @Given("User Set Patterns service api endpoint")
    public void userSetPatternsServiceApiEndpoint() {
        RestAssured.baseURI="http://www.colourlovers.com/api/patterns";
    }


    @Then("User Set Request Headers")
    public Response userSetRequestHeaders() {
        var response = RestAssured.given().header("User-Agent",
                "Mozilla/5.0 ")
                .contentType(ContentType.XML)
                .when()
                .get(RestAssured.baseURI)
                .then()
                .extract()
                .response();
        return response;
    }

    @Then("Verify numViews Values Greater Than 4000")
    public void verifyNumViewsValuesGreaterThan() {
        List<String> values = userSetRequestHeaders().xmlPath().getList("patterns.pattern.numViews");
        for (int i=0;i<20;i++){
            if(Integer.parseInt(values.get(i))>4000){
                flag = true;
                System.out.println("NumViews Values of "+" "+i+" "+"Greater Than 4000 are : "+ Integer.parseInt(values.get(i)));
            }else
            {
                flag = false;
            }
            softAssert.assertTrue(flag);
        }
        softAssert.assertAll();
    }


}

