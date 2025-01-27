package day09;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestCreateUser {


    @Test
    public void testCreateUser(ITestContext context) {

        Faker faker = new Faker();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", faker.name().fullName());
        jsonObject.put("job", faker.job());


        Response response = given()
                .contentType("application/json")
                .body(jsonObject.toString())
                .when()
                .post("https://reqres.in/api/users");


        Assert.assertEquals(201, response.statusCode());

        String id = response.jsonPath().getString("id");

        context.setAttribute("user_id", id);

        System.out.println(id + " from testCreateUser");
    }


}
