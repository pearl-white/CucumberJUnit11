package utilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.CustomResponse;
import models.RequestBody;
import org.junit.Assert;

import java.io.IOException;

public class APIrunner {

    private static CustomResponse customResponse;
    private static Response response;
    private static ObjectMapper mapper = new ObjectMapper();


    public static void runGET(String url){

        response = RestAssured.get(url);
        System.out.println("STATUS: "+response.statusCode());
        Assert.assertTrue(response.statusCode()==200);
        convertResponseToObject(response.asString());

    }

    public static void runDELETE(String url){

        response = RestAssured.delete(url);
        System.out.println("STATUS: "+response.statusCode());
        Assert.assertTrue(response.statusCode()==200);
        convertResponseToObject(response.asString());

    }
    public static void runPOST(String url, RequestBody requestBody){

        response = RestAssured.given().
                    contentType(ContentType.JSON).body(requestBody).when().post(url);
        System.out.println("STATUS: "+response.statusCode());
        convertResponseToObject(response.asString());
    }

    public static void runUPDATE(String url, RequestBody requestBody){

        response = RestAssured.given().
                contentType(ContentType.JSON).body(requestBody).when().put(url);
        System.out.println("STATUS: "+response.statusCode());
        convertResponseToObject(response.asString());
    }

    private static void convertResponseToObject(String response){

        try {
            customResponse = mapper.readValue(response, CustomResponse.class);
        } catch (IOException e) {
            System.out.println("JSON string couldn't map!");
        }
    }

    public static CustomResponse getCustomResponse(){
        if(customResponse==null){
            System.out.println("Please run API first!");
            return null;
        }
        return customResponse;
    }

    public static Response getResponse(){
        return response;
    }

}
