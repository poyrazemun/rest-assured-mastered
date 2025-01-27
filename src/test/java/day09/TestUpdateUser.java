package day09;

import com.github.javafaker.Faker;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestUpdateUser {

    @Test
    public void testUpdateUser(ITestContext context) {

        String user_id = context.getAttribute("user_id").toString();

        Faker faker = new Faker();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", faker.name().fullName());
        jsonObject.put("job", faker.job());


        given()
                .pathParam("id", user_id)
                .when()
                .put("https://reqres.in/api/users/{id}")
                .then().statusCode(200);

        System.out.println(user_id + " id from testUpdateUser");


    }


}
