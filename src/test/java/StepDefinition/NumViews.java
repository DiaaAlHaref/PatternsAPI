package StepDefinition;

import POM.Patterns;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.asserts.SoftAssert;

public class NumViews {
    boolean flag;
    SoftAssert softAssert = new SoftAssert();
    Patterns patterns = new Patterns();

    @Given("User Go To Patterns service api endpoint")
    public void userGoToPatternsServiceApiEndpoint() {
        patterns.BaseURL();
    }

    @Then("User Set Request Headers")
    public void userSetRequestHeaders() {
       patterns.SetRequestHeaders();
    }

    @Then("Verify numViews Values Greater Than {int}")
    public void verifyNumViewsValuesGreaterThan(int value) {
        /*int[] intArray= new int[patterns.ValuesList().size()];
        int count=0;*/
        for (int i=0;i<20;i++){
            if(Integer.parseInt(patterns.ValuesList().get(i))>value){
              /*  intArray[count]=Integer.parseInt(patterns.ValuesList().get(i));
                count++;*/
                flag = true;
                System.out.println("NumViews Values of "+" "+i+" "+"Greater Than "+value+          " are : "+
                        Integer.parseInt(patterns.ValuesList().get(i)));
            }else
            {
                flag = false;
                System.out.println("NumViews Values of "+" "+i+" "+"less than "+ value+" :" +
                        Integer.parseInt(patterns.ValuesList().get(i)));
            }
            softAssert.assertTrue(flag);
        }
        softAssert.assertAll();
    }



}

