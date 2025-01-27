package day03;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class TestPathAndQueryParams {

    @Test
    public void testPathAndQueryParams() {


        int reportType = 0;
        int id = 1073580;

        Map<String, String> pathParams = new HashMap<>();
        pathParams.put("service", "racun");
        pathParams.put("operation", "calculasyon");
        pathParams.put("action", "calculateBill");

        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("reportType", reportType);
        queryParams.put("id", id);


        RestAssured.baseURI = "https://testCalculator/invoice-fatura-api/api";

        given().
                pathParams(pathParams)
                .queryParams(queryParams)
                .when()
                .post("/{service}/{operation}/{action}")
                .then().statusCode(204);

    }
}
