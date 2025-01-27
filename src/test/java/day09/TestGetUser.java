package day09;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestGetUser {

    @Test
    public void testGetUser(ITestContext context) {

        String user_id = context.getAttribute("user_id").toString();

        given().pathParam("id", user_id)
                .when()
                .get("https://reqres.in/api/users/{id}")
                .then().statusCode(200);

        System.out.println(user_id + " from testGetUser");

    }

}
