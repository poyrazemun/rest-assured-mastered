package day09;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestDeleteUser {

    @Test
    public void testDeleteUser(ITestContext context) {
        String user_id = context.getAttribute("user_id").toString();

        given().pathParam("id", user_id)
                .when()
                .delete("https://reqres.in/api/users/{id}")
                .then().statusCode(204);


        System.out.println(user_id + " id from testDeleteUser");
    }

}
