package day07;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestBasicAuthentication {

    @Test(priority = 1)
    public void testBasicAuthentication() {
        Response response = given()
                .auth().basic("postman", "password")
                .when()
                .get("https://postman-echo.com/basic-auth");


        Assert.assertEquals(200, response.statusCode());
        Assert.assertTrue(response.jsonPath().getBoolean("authenticated"));

        System.out.println("Basic Authentication Time:" + response.getTimeIn(TimeUnit.MILLISECONDS));

    }

    @Test(priority = 2)
    public void testDigestAuthentication() {
        Response response = given()
                .auth().digest("postman", "password")
                .when()
                .get("https://postman-echo.com/basic-auth");


        Assert.assertEquals(200, response.statusCode());
        Assert.assertTrue(response.jsonPath().getBoolean("authenticated"));

        System.out.println("Digest Authentication Time: " + response.getTimeIn(TimeUnit.MILLISECONDS));

    }

    @Test(priority = 3)
    public void testPreemptiveAuthentication() {
        Response response = given()
                .auth().preemptive().basic("postman", "password")
                .when()
                .get("https://postman-echo.com/basic-auth");


        Assert.assertEquals(200, response.statusCode());
        Assert.assertTrue(response.jsonPath().getBoolean("authenticated"));

        System.out.println("Preemptive Authentication Time: " + response.getTimeIn(TimeUnit.MILLISECONDS));

    }

    @Test(enabled = false)
    public void testBearerTokenAuthentication() {
        String bearerToken = "imaginaryBearerToken12365933655336563";
        given()
                .header("Authorization", "Bearer " + bearerToken)
                .when()
                .get("thisIsSomeRequest")
                .then().statusCode(200);

    }

    @Test(enabled = false)
    public void testOauth1Authentication() {
        given().
                auth().oauth("consumerKey", "consumerSecret", "accessToken", "tokenSecret")
                .when()
                .get("myUrl")
                .then()
                .statusCode(200);
    }

    @Test(enabled = false)
    public void testOauth2Authentication() {
        given().
                auth().oauth2("token")//bu token manuel olarak generate edilecek
                .when()
                .get("myUrl")
                .then()
                .statusCode(200);
    }

    @Test(enabled = false)
    public void testAPIKeyAuthentication() {
        given().queryParam("keyName", "value")
                .when()
                .get("url")
                .then()
                .statusCode(200);
    }

}
