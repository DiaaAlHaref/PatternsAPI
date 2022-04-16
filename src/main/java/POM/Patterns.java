package POM;


import FileReader.PropertiesFile;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class Patterns {

    boolean flag;
    SoftAssert softAssert = new SoftAssert();

    private String[] data = PropertiesFile.propertiesFileReader(new String[]{"BaseUrl","User_Agent","User_Agent_Type"});
    private String BaseUrl = data[0];
    private String User_Agent= data[1];
    private String User_Agent_Type= data[2];

    public void BaseURL(){
        RestAssured.baseURI=BaseUrl;
    }

    public Response SetRequestHeaders(){
        var response = RestAssured.given().header(User_Agent,User_Agent_Type)
                .contentType(ContentType.XML)
                .when()
                .get(BaseUrl)
                .then()
                .extract()
                .response();
        return response;
    }

    public void VerifyResponseValues(){
        List<String> values = SetRequestHeaders().xmlPath().getList("patterns.pattern.numViews");
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
