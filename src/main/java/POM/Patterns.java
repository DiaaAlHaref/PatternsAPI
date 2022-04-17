package POM;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class Patterns {
    FileInputStream fis;
    Properties properties = new Properties();

    public void BaseURL() throws IOException {
        fis = new FileInputStream("src/test/resources/DataDriven/data.properties");
        properties.load(fis);
        RestAssured.baseURI=properties.getProperty("BaseUrl");
    }

    public Response SetRequestHeaders(){
        var response = RestAssured.given().header(properties.getProperty("User_Agent"),properties.getProperty("User_Agent_Type"))
                .contentType(ContentType.XML)
                .when()
                .get(properties.getProperty("BaseUrl"))
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
