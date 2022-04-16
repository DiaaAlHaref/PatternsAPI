package POM;


import FileReader.PropertiesFile;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.List;

public class Patterns {




    private final String[] data = PropertiesFile.propertiesFileReader(new String[]{"BaseUrl","User_Agent","User_Agent_Type"});
    private final String BaseUrl = data[0];
    private final String User_Agent= data[1];
    private final String User_Agent_Type= data[2];

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

    public List<String> ValuesList(){
        List<String> values = SetRequestHeaders().xmlPath().getList("patterns.pattern.numViews");
        return values;
    }

}
